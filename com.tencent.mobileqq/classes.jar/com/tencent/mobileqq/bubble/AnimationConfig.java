package com.tencent.mobileqq.bubble;

import android.util.SparseArray;
import java.util.ArrayList;

public class AnimationConfig
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d;
  public int e;
  public int f;
  public int[] g;
  public int h;
  public String[] i;
  public int[] j;
  public int[] k;
  public String l;
  public boolean m;
  public int n = -1;
  public int o;
  public int p;
  public int q;
  public int r;
  public boolean s = true;
  public boolean t = true;
  public int u = 0;
  public SparseArray<AnimationConfig.AnimationStep> v = null;
  public ArrayList<BubbleNewAnimConf> w = new ArrayList();
  public int x;
  
  public static void a(AnimationConfig paramAnimationConfig)
  {
    if (paramAnimationConfig == null) {
      return;
    }
    if (paramAnimationConfig.w.size() > 0) {
      return;
    }
    int i1 = paramAnimationConfig.n;
    if ((i1 != 10) && (i1 != 11)) {
      return;
    }
    Object localObject = paramAnimationConfig.v;
    if (localObject != null)
    {
      if (((SparseArray)localObject).size() != 3) {
        return;
      }
      localObject = (AnimationConfig.AnimationStep)paramAnimationConfig.v.get(0);
      AnimationConfig.AnimationStep localAnimationStep1 = (AnimationConfig.AnimationStep)paramAnimationConfig.v.get(1);
      AnimationConfig.AnimationStep localAnimationStep2 = (AnimationConfig.AnimationStep)paramAnimationConfig.v.get(2);
      if ((localObject != null) && (localAnimationStep1 != null))
      {
        if (localAnimationStep2 == null) {
          return;
        }
        a(paramAnimationConfig, (AnimationConfig.AnimationStep)localObject, localAnimationStep1, localAnimationStep2);
      }
    }
  }
  
  private static void a(AnimationConfig paramAnimationConfig, AnimationConfig.AnimationStep paramAnimationStep1, AnimationConfig.AnimationStep paramAnimationStep2, AnimationConfig.AnimationStep paramAnimationStep3)
  {
    BubbleNewAnimConf.PathAnimConf localPathAnimConf1;
    BubbleNewAnimConf.PathAnimConf localPathAnimConf2;
    if (paramAnimationConfig.n == 10)
    {
      localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf1.a = "step1";
      localPathAnimConf1.e = paramAnimationStep1.c;
      localPathAnimConf1.d = paramAnimationStep1.a;
      localPathAnimConf1.m = 0.1F;
      localPathAnimConf1.n = 0.0F;
      localPathAnimConf1.o = 0.1F;
      localPathAnimConf1.p = 0.0F;
      localPathAnimConf1.b = (paramAnimationStep1.a * 125);
      paramAnimationConfig.w.add(localPathAnimConf1);
      localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf1.a = "step2";
      localPathAnimConf1.e = paramAnimationStep2.c;
      localPathAnimConf1.d = paramAnimationStep2.a;
      localPathAnimConf1.m = 0.1F;
      localPathAnimConf1.n = 0.0F;
      localPathAnimConf1.o = 0.9F;
      localPathAnimConf1.p = 0.0F;
      localPathAnimConf1.b = 600L;
      paramAnimationConfig.w.add(localPathAnimConf1);
      localPathAnimConf2 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf2.a = "step3";
      localPathAnimConf2.e = paramAnimationStep3.c;
      localPathAnimConf2.d = paramAnimationStep3.a;
      localPathAnimConf2.m = 0.9F;
      localPathAnimConf2.n = 0.0F;
      localPathAnimConf2.o = 0.9F;
      localPathAnimConf2.p = 0.0F;
      localPathAnimConf2.b = (paramAnimationStep3.a * 125);
      paramAnimationConfig.w.add(localPathAnimConf2);
      paramAnimationConfig.w.add(localPathAnimConf1.a());
    }
    if (paramAnimationConfig.n == 11)
    {
      localPathAnimConf1 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf1.a = "step1";
      localPathAnimConf1.e = paramAnimationStep1.c;
      localPathAnimConf1.d = paramAnimationStep1.a;
      localPathAnimConf1.m = 0.1F;
      localPathAnimConf1.n = 0.0F;
      localPathAnimConf1.o = 0.1F;
      localPathAnimConf1.p = 0.0F;
      localPathAnimConf1.b = (paramAnimationStep1.a * 125);
      paramAnimationConfig.w.add(localPathAnimConf1);
      paramAnimationStep1 = new BubbleNewAnimConf.PathAnimConf();
      paramAnimationStep1.a = "step2";
      paramAnimationStep1.e = paramAnimationStep2.c;
      paramAnimationStep1.d = paramAnimationStep2.a;
      paramAnimationStep1.m = 0.1F;
      paramAnimationStep1.n = 0.0F;
      paramAnimationStep1.o = 0.9F;
      paramAnimationStep1.p = 0.0F;
      paramAnimationStep1.b = 800L;
      paramAnimationConfig.w.add(paramAnimationStep1);
      localPathAnimConf2 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf2.a = "step3";
      localPathAnimConf2.e = paramAnimationStep2.c;
      localPathAnimConf2.d = paramAnimationStep2.a;
      localPathAnimConf2.m = 0.9F;
      localPathAnimConf2.n = 0.0F;
      localPathAnimConf2.o = 1.0F;
      localPathAnimConf2.p = 0.1F;
      localPathAnimConf2.q = 0.95F;
      localPathAnimConf2.r = 0.0F;
      localPathAnimConf2.s = 1.0F;
      localPathAnimConf2.t = 0.05F;
      localPathAnimConf2.y = 0;
      localPathAnimConf2.z = -90;
      localPathAnimConf2.b = 600L;
      paramAnimationConfig.w.add(localPathAnimConf2);
      BubbleNewAnimConf.PathAnimConf localPathAnimConf3 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf3.a = "step4";
      localPathAnimConf3.e = paramAnimationStep2.c;
      localPathAnimConf3.d = paramAnimationStep2.a;
      localPathAnimConf3.m = 1.0F;
      localPathAnimConf3.n = 0.1F;
      localPathAnimConf3.o = 1.0F;
      localPathAnimConf3.p = 0.9F;
      localPathAnimConf3.y = -90;
      localPathAnimConf3.z = -90;
      localPathAnimConf3.b = 800L;
      paramAnimationConfig.w.add(localPathAnimConf3);
      BubbleNewAnimConf.PathAnimConf localPathAnimConf4 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf4.a = "step5";
      localPathAnimConf4.e = paramAnimationStep2.c;
      localPathAnimConf4.d = paramAnimationStep2.a;
      localPathAnimConf4.m = 1.0F;
      localPathAnimConf4.n = 0.9F;
      localPathAnimConf4.o = 0.9F;
      localPathAnimConf4.p = 1.0F;
      localPathAnimConf4.q = 1.0F;
      localPathAnimConf4.r = 0.95F;
      localPathAnimConf4.s = 0.95F;
      localPathAnimConf4.t = 1.0F;
      localPathAnimConf4.y = -90;
      localPathAnimConf4.z = -180;
      localPathAnimConf4.b = 600L;
      paramAnimationConfig.w.add(localPathAnimConf4);
      BubbleNewAnimConf.PathAnimConf localPathAnimConf5 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf5.a = "step6";
      localPathAnimConf5.e = paramAnimationStep2.c;
      localPathAnimConf5.d = paramAnimationStep2.a;
      localPathAnimConf5.m = 0.9F;
      localPathAnimConf5.n = 1.0F;
      localPathAnimConf5.o = 0.1F;
      localPathAnimConf5.p = 1.0F;
      localPathAnimConf5.y = -180;
      localPathAnimConf5.z = -180;
      localPathAnimConf5.b = 800L;
      paramAnimationConfig.w.add(localPathAnimConf5);
      BubbleNewAnimConf.PathAnimConf localPathAnimConf6 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf6.a = "step7";
      localPathAnimConf6.e = paramAnimationStep2.c;
      localPathAnimConf6.d = paramAnimationStep2.a;
      localPathAnimConf6.m = 0.1F;
      localPathAnimConf6.n = 1.0F;
      localPathAnimConf6.o = 0.0F;
      localPathAnimConf6.p = 0.9F;
      localPathAnimConf6.q = 0.05F;
      localPathAnimConf6.r = 1.0F;
      localPathAnimConf6.s = 0.0F;
      localPathAnimConf6.t = 0.95F;
      localPathAnimConf6.y = -180;
      localPathAnimConf6.z = -270;
      localPathAnimConf6.b = 600L;
      paramAnimationConfig.w.add(localPathAnimConf6);
      BubbleNewAnimConf.PathAnimConf localPathAnimConf7 = new BubbleNewAnimConf.PathAnimConf();
      localPathAnimConf7.a = "step8";
      localPathAnimConf7.e = paramAnimationStep2.c;
      localPathAnimConf7.d = paramAnimationStep2.a;
      localPathAnimConf7.m = 0.0F;
      localPathAnimConf7.n = 0.9F;
      localPathAnimConf7.o = 0.0F;
      localPathAnimConf7.p = 0.1F;
      localPathAnimConf7.y = -270;
      localPathAnimConf7.z = -270;
      localPathAnimConf7.b = 800L;
      paramAnimationConfig.w.add(localPathAnimConf7);
      paramAnimationStep2 = new BubbleNewAnimConf.PathAnimConf();
      paramAnimationStep2.a = "turnback";
      paramAnimationStep2.e = paramAnimationStep3.c;
      paramAnimationStep2.d = paramAnimationStep3.a;
      paramAnimationStep2.m = 0.0F;
      paramAnimationStep2.n = 0.1F;
      paramAnimationStep2.o = 0.0F;
      paramAnimationStep2.p = 0.1F;
      paramAnimationStep2.y = -270;
      paramAnimationStep2.z = -270;
      paramAnimationStep2.b = (paramAnimationStep3.a * 125);
      paramAnimationConfig.w.add(paramAnimationStep2);
      paramAnimationConfig.w.add(localPathAnimConf7.a());
      paramAnimationConfig.w.add(localPathAnimConf6.a());
      paramAnimationConfig.w.add(localPathAnimConf5.a());
      paramAnimationConfig.w.add(localPathAnimConf4.a());
      paramAnimationConfig.w.add(localPathAnimConf3.a());
      paramAnimationConfig.w.add(localPathAnimConf2.a());
      paramAnimationConfig.w.add(paramAnimationStep1.a());
      paramAnimationConfig.w.add(localPathAnimConf1.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.AnimationConfig
 * JD-Core Version:    0.7.0.1
 */