/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.yihtserns.test.gec;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author yihtserns
 */
public class MainTest {

    @Test
    public void canHaveCircularDependencyBetweenJavaClassAndGroovyClass() {
        DependsOnGroovyClass depsOnGroovy = new DependsOnGroovyClass();
        DependsOnJavaClass depsOnJava = new DependsOnJavaClass();

        depsOnGroovy.dependency = depsOnJava;
        depsOnJava.setDependency(depsOnGroovy);

        Assert.assertSame(depsOnGroovy, depsOnJava.getDependency());
        Assert.assertSame(depsOnJava, depsOnGroovy.dependency);
    }

}
