package com.tencent.biz.qqcircle.publish.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqcircle.publish.util.AnimateUtils;

class OverScroller$SplineOverScroller
{
  private static float o;
  private static float q = (float)(Math.log(0.78D) / Math.log(0.9D));
  private static final float[] r = new float[101];
  private static final float[] s = new float[101];
  private int a;
  private int b;
  private int c;
  private int d;
  private float e;
  private float f;
  private long g;
  private int h;
  private int i;
  private int j;
  private boolean k = true;
  private int l;
  private float m = ViewConfiguration.getScrollFriction();
  private int n = 0;
  private int p = 0;
  private float t;
  private double u;
  private long v;
  
  static
  {
    float f1 = 0.0F;
    int i1 = 0;
    float f2 = 0.0F;
    if (i1 < 100)
    {
      float f5 = i1 / 100.0F;
      float f3 = 1.0F;
      for (;;)
      {
        float f4 = (f3 - f1) / 2.0F + f1;
        float f6 = 1.0F - f4;
        float f7 = f4 * 3.0F * f6;
        float f8 = f4 * f4 * f4;
        float f9 = (f6 * 0.175F + f4 * 0.35F) * f7 + f8;
        if (Math.abs(f9 - f5) < 1.E-005D)
        {
          r[i1] = (f7 * (f6 * 0.5F + f4) + f8);
          f3 = 1.0F;
          for (;;)
          {
            f4 = (f3 - f2) / 2.0F + f2;
            f6 = 1.0F - f4;
            f7 = f4 * 3.0F * f6;
            f8 = f4 * f4 * f4;
            f9 = (f6 * 0.5F + f4) * f7 + f8;
            if (Math.abs(f9 - f5) < 1.E-005D)
            {
              s[i1] = (f7 * (f6 * 0.175F + f4 * 0.35F) + f8);
              i1 += 1;
              break;
            }
            if (f9 > f5) {
              f3 = f4;
            } else {
              f2 = f4;
            }
          }
        }
        if (f9 > f5) {
          f3 = f4;
        } else {
          f1 = f4;
        }
      }
    }
    float[] arrayOfFloat = r;
    s[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private double a(int paramInt)
  {
    return Math.log(Math.abs(paramInt) * 0.35F / (this.m * o));
  }
  
  static void a(Context paramContext)
  {
    o = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private double b(int paramInt)
  {
    double d2 = a(paramInt);
    float f1 = q;
    double d3 = f1;
    Double.isNaN(d3);
    double d1 = this.m * o;
    double d4 = f1;
    Double.isNaN(d4);
    d2 = Math.exp(d4 / (d3 - 1.0D) * d2);
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  private int c(int paramInt)
  {
    double d1 = a(paramInt);
    double d2 = q;
    Double.isNaN(d2);
    return (int)(Math.exp(d1 / (d2 - 1.0D)) * 1000.0D);
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    float f3 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(f3 * 100.0F);
    if (paramInt1 < 100)
    {
      float f4 = paramInt1 / 100.0F;
      paramInt2 = paramInt1 + 1;
      float f5 = paramInt2 / 100.0F;
      float[] arrayOfFloat = s;
      float f1 = arrayOfFloat[paramInt1];
      float f2 = arrayOfFloat[paramInt2];
      f3 = (f3 - f4) / (f5 - f4);
      this.h = ((int)(this.h * (f1 + f3 * (f2 - f1))));
    }
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = false;
    this.n = 1;
    this.a = paramInt1;
    this.c = paramInt2;
    this.l = (paramInt2 - paramInt1);
    this.h = OverScroller.a;
  }
  
  private void e()
  {
    long l1 = this.g;
    int i1 = this.h;
    l1 += i1;
    i1 = (int)(i1 / this.i * 100.0F);
    if (i1 < 100)
    {
      f1 = i1 / 100.0F;
      int i2 = i1 + 1;
      float f2 = i2 / 100.0F;
      float[] arrayOfFloat = r;
      float f3 = arrayOfFloat[i1];
      f1 = (arrayOfFloat[i2] - f3) / (f2 - f1);
    }
    else
    {
      f1 = 0.0F;
    }
    this.e = (f1 * this.j / this.i * 1000.0F);
    float f1 = this.e;
    double d1 = f1;
    double d2 = this.u;
    Double.isNaN(d1);
    double d3 = l1 - this.v;
    Double.isNaN(d3);
    this.f = ((float)((d1 - d2) / d3 * 1000.0D));
    a(this.c, this.l, (int)f1, OverScroller.a);
    this.g = l1;
    d();
  }
  
  void a()
  {
    this.b = this.c;
    this.k = true;
  }
  
  void a(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = false;
    this.a = paramInt1;
    this.c = (paramInt1 + paramInt2);
    this.g = AnimationUtils.currentAnimationTimeMillis();
    this.h = paramInt3;
    this.f = 0.0F;
    this.d = 0;
    this.n = 4;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt2 * 0.09606F / (paramInt4 * 1.E-005F);
    float f1;
    if (paramInt3 > 0) {
      f1 = 10.0F;
    } else {
      f1 = -10.0F;
    }
    if (Math.abs(paramInt3) < f2) {
      f1 = paramInt3 * 10.0F / f2;
    }
    this.a = paramInt1;
    this.c = paramInt1;
    this.d = paramInt3;
    this.l = paramInt2;
    this.g = AnimationUtils.currentAnimationTimeMillis();
    this.h = paramInt4;
    this.t = f1;
    this.b = this.a;
    this.n = 3;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.i = 0;
    this.h = 0;
    this.l = paramInt5;
    this.k = false;
    this.d = paramInt2;
    float f1 = paramInt2;
    this.e = f1;
    this.g = AnimationUtils.currentAnimationTimeMillis();
    this.a = paramInt1;
    this.b = paramInt1;
    if ((paramInt1 <= paramInt4) && (paramInt1 >= paramInt3))
    {
      this.n = 0;
      double d1 = 0.0D;
      if (paramInt2 != 0)
      {
        if (this.p == 1)
        {
          paramInt5 = c(paramInt2) * 3 / 2;
          this.i = paramInt5;
          this.h = paramInt5;
        }
        else
        {
          paramInt5 = c(paramInt2);
          this.i = paramInt5;
          this.h = paramInt5;
        }
        this.f = ((float)(a(paramInt2) * 1000.0D));
        d1 = b(paramInt2);
      }
      double d2 = Math.signum(f1);
      Double.isNaN(d2);
      this.j = ((int)(d1 * d2));
      this.c = (paramInt1 + this.j);
      paramInt1 = this.c;
      if (paramInt1 < paramInt3)
      {
        c(this.a, paramInt1, paramInt3);
        this.c = paramInt3;
      }
      paramInt1 = this.c;
      if (paramInt1 > paramInt4)
      {
        c(this.a, paramInt1, paramInt4);
        this.c = paramInt4;
      }
      this.u = paramInt2;
      this.v = this.g;
      return;
    }
    if (paramInt1 > paramInt4) {
      paramInt3 = paramInt4;
    }
    d(paramInt1, paramInt3, paramInt2);
  }
  
  void b(float paramFloat)
  {
    int i1 = this.a;
    this.b = (i1 + Math.round(paramFloat * (this.c - i1)));
  }
  
  boolean b()
  {
    int i1 = this.n;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
        return false;
      }
    }
    else
    {
      if (this.h >= this.i) {
        break label46;
      }
      e();
    }
    d();
    return true;
    label46:
    return false;
  }
  
  boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = true;
    this.c = paramInt1;
    this.a = paramInt1;
    this.d = 0;
    this.g = AnimationUtils.currentAnimationTimeMillis();
    this.h = 0;
    if (paramInt1 < paramInt2) {
      d(paramInt1, paramInt2, 0);
    } else if (paramInt1 > paramInt3) {
      d(paramInt1, paramInt3, 0);
    }
    return this.k ^ true;
  }
  
  boolean c()
  {
    int i1 = this.n;
    if ((i1 != 0) && (i1 != 1) && (i1 != 3))
    {
      d();
      return true;
    }
    return false;
  }
  
  boolean d()
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    long l2 = l1 - this.g;
    int i1 = this.h;
    if (l2 > i1) {
      return false;
    }
    double d1 = 0.0D;
    int i2 = this.n;
    float f2 = 1.0F;
    float f1;
    float f3;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 == 3)
        {
          f1 = (float)l2 / i1 - 1.0F;
          f2 = this.l;
          f3 = this.t;
          d1 = f2 * f1 * f1 * f1 * f1 * (f1 * f3 + f3);
        }
      }
      else {
        d1 = AnimateUtils.a((float)l2 / i1) * this.l;
      }
    }
    else
    {
      f3 = (float)l2 / this.i;
      i1 = (int)(f3 * 100.0F);
      if (i1 < 100)
      {
        f2 = i1 / 100.0F;
        i2 = i1 + 1;
        f1 = i2 / 100.0F;
        float[] arrayOfFloat = r;
        float f4 = arrayOfFloat[i1];
        f1 = (arrayOfFloat[i2] - f4) / (f1 - f2);
        f2 = f4 + (f3 - f2) * f1;
      }
      else
      {
        f1 = 0.0F;
      }
      i1 = this.j;
      d1 = f2 * i1;
      this.e = (f1 * i1 / this.i * 1000.0F);
      double d2 = this.e;
      double d3 = this.u;
      Double.isNaN(d2);
      double d4 = l1 - this.v;
      Double.isNaN(d4);
      this.f = ((float)((d2 - d3) / d4 * 1000.0D));
    }
    this.b = (this.a + (int)Math.round(d1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.OverScroller.SplineOverScroller
 * JD-Core Version:    0.7.0.1
 */