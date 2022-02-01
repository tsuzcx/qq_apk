package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class AutoFitScroller
{
  public final float a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private long m;
  private int n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private boolean t = true;
  private Interpolator u;
  private float v = 0.0F;
  private float w = 1.0F;
  private float x;
  
  public AutoFitScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoFitScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this.u = paramInterpolator;
    this.a = (paramContext.getResources().getDisplayMetrics().density * 800.0F * 386.0878F * ViewConfiguration.getScrollFriction());
  }
  
  private float a(float paramFloat)
  {
    paramFloat *= this.r;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F;
    }
    return paramFloat * this.s;
  }
  
  public int a(int paramInt)
  {
    return (int)(paramInt * paramInt / (this.a * 2.0F));
  }
  
  public int a(boolean paramBoolean, int paramInt)
  {
    paramInt = (int)Math.sqrt(paramInt * 2 * this.a);
    if (paramBoolean) {
      return -paramInt;
    }
    return paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b = 0;
    this.t = false;
    this.n = paramInt5;
    this.m = AnimationUtils.currentAnimationTimeMillis();
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = (paramInt1 + paramInt3);
    this.f = (paramInt2 + paramInt4);
    this.p = paramInt3;
    this.q = paramInt4;
    this.o = (1.0F / this.n);
    this.r = 8.0F;
    this.s = 1.0F;
    this.s = (1.0F / a(1.0F));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.b = 1;
    this.t = false;
    float f3 = (float)Math.hypot(paramInt3, paramInt4);
    this.x = f3;
    this.n = ((int)(1000.0F * f3 / this.a));
    this.m = AnimationUtils.currentAnimationTimeMillis();
    this.c = paramInt1;
    this.d = paramInt2;
    float f2 = 1.0F;
    if (f3 == 0.0F) {
      f1 = 1.0F;
    } else {
      f1 = paramInt3 / f3;
    }
    this.v = f1;
    if (f3 == 0.0F) {
      f1 = f2;
    } else {
      f1 = paramInt4 / f3;
    }
    this.w = f1;
    paramInt3 = (int)(f3 * f3 / (this.a * 2.0F));
    this.g = paramInt5;
    this.h = paramInt6;
    this.i = paramInt7;
    this.j = paramInt8;
    float f1 = paramInt3;
    this.e = (paramInt1 + Math.round(this.v * f1));
    this.e = Math.min(this.e, this.h);
    this.e = Math.max(this.e, this.g);
    this.f = (paramInt2 + Math.round(f1 * this.w));
    this.f = Math.min(this.f, this.j);
    this.f = Math.max(this.f, this.i);
  }
  
  public final boolean a()
  {
    return this.t;
  }
  
  public final int b()
  {
    return this.k;
  }
  
  public final int c()
  {
    return this.l;
  }
  
  public boolean d()
  {
    if (this.t) {
      return false;
    }
    int i1 = (int)(AnimationUtils.currentAnimationTimeMillis() - this.m);
    if (i1 < this.n)
    {
      int i2 = this.b;
      float f1;
      if (i2 != 0)
      {
        if (i2 != 1) {
          return true;
        }
        f1 = i1 / 1000.0F;
        f1 = this.x * f1 - this.a * f1 * f1 / 2.0F;
        this.k = (this.c + Math.round(this.v * f1));
        this.k = Math.min(this.k, this.h);
        this.k = Math.max(this.k, this.g);
        this.l = (this.d + Math.round(f1 * this.w));
        this.l = Math.min(this.l, this.j);
        this.l = Math.max(this.l, this.i);
        if ((this.k == this.e) && (this.l == this.f))
        {
          this.t = true;
          return true;
        }
      }
      else
      {
        f1 = i1 * this.o;
        Interpolator localInterpolator = this.u;
        if (localInterpolator == null) {
          f1 = a(f1);
        } else {
          f1 = localInterpolator.getInterpolation(f1);
        }
        this.k = (this.c + Math.round(this.p * f1));
        this.l = (this.d + Math.round(f1 * this.q));
        if ((this.k == this.e) && (this.l == this.f))
        {
          this.t = true;
          return true;
        }
      }
    }
    else
    {
      this.k = this.e;
      this.l = this.f;
      this.t = true;
    }
    return true;
  }
  
  public void e()
  {
    this.k = this.e;
    this.l = this.f;
    this.t = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoFitScroller
 * JD-Core Version:    0.7.0.1
 */