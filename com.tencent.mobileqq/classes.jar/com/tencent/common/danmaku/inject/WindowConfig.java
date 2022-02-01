package com.tencent.common.danmaku.inject;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.util.DanmakuUtils;

public class WindowConfig
{
  private static boolean j = true;
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private float f;
  private float g;
  private boolean h = true;
  private boolean i;
  private int k;
  private int l;
  private float m;
  private float n;
  private float o;
  private float p;
  private boolean q = false;
  
  public WindowConfig()
  {
    DisplayMetrics localDisplayMetrics = DanmakuDependImp.a().b().b().getDisplayMetrics();
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    if (this.q)
    {
      this.l = Math.max(i1, i2);
      this.k = Math.min(i1, i2);
    }
    else
    {
      this.l = Math.min(i1, i2);
      this.k = Math.max(i1, i2);
    }
    c(8000);
    b(12);
    a(3);
    a(1.5F);
    d(1);
    c(5.0F);
    b(5.0F);
    b(true);
    c(true);
    d(16.0F);
    e(0.0F);
    f(5.0F);
    g(4.0F);
  }
  
  public static void a(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static boolean a()
  {
    return j;
  }
  
  public void a(float paramFloat)
  {
    this.d = DanmakuUtils.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(float paramFloat)
  {
    this.g = DanmakuUtils.a(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.b = DanmakuUtils.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(float paramFloat)
  {
    this.f = DanmakuUtils.a(paramFloat);
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(float paramFloat)
  {
    this.m = DanmakuUtils.a(paramFloat);
  }
  
  public void d(int paramInt)
  {
    this.e = DanmakuUtils.a(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      int i1 = this.k;
      this.k = this.l;
      this.l = i1;
    }
    this.q = paramBoolean;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public void e(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void f(float paramFloat)
  {
    this.o = DanmakuUtils.a(paramFloat);
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public void g(float paramFloat)
  {
    this.p = DanmakuUtils.a(paramFloat);
  }
  
  public float h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.e;
  }
  
  public float m()
  {
    return this.m;
  }
  
  public float n()
  {
    return this.n;
  }
  
  public float o()
  {
    return this.o;
  }
  
  public float p()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.inject.WindowConfig
 * JD-Core Version:    0.7.0.1
 */