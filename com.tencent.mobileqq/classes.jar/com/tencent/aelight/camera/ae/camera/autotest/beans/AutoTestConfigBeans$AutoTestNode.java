package com.tencent.aelight.camera.ae.camera.autotest.beans;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.HashMap;

public class AutoTestConfigBeans$AutoTestNode
{
  public String a;
  public boolean b;
  public int c;
  public int d;
  public String e;
  public boolean f;
  public HashMap<String, Integer> g;
  public AutoTestConfigBeans.LipsLUTConfig h;
  public AutoTestConfigBeans.SpecialConfig i;
  public AutoTestConfigBeans.SpecialConfig j;
  public AutoTestConfigBeans.SpecialConfig k;
  public String l;
  public AutoTestConfigBeans.SpecialConfig m;
  public String n;
  private HashMap<BeautyRealConfig.TYPE, Integer> p;
  
  public AutoTestConfigBeans$AutoTestNode(AutoTestConfigBeans paramAutoTestConfigBeans) {}
  
  public HashMap<BeautyRealConfig.TYPE, Integer> a()
  {
    return this.p;
  }
  
  public AutoTestNode b()
  {
    AutoTestNode localAutoTestNode = new AutoTestNode(this.o);
    localAutoTestNode.a = this.a;
    localAutoTestNode.b = this.b;
    localAutoTestNode.c = this.c;
    localAutoTestNode.d = this.d;
    localAutoTestNode.e = this.e;
    localAutoTestNode.f = this.f;
    localAutoTestNode.g = this.g;
    localAutoTestNode.h = this.h;
    localAutoTestNode.i = this.i;
    localAutoTestNode.j = this.j;
    localAutoTestNode.k = this.k;
    localAutoTestNode.l = this.l;
    localAutoTestNode.m = this.m;
    localAutoTestNode.n = this.n;
    localAutoTestNode.p = this.p;
    return localAutoTestNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.AutoTestNode
 * JD-Core Version:    0.7.0.1
 */