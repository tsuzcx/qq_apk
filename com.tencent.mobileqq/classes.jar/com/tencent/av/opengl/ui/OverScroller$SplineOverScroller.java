package com.tencent.av.opengl.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

class OverScroller$SplineOverScroller
{
  private static float o;
  private static float p = (float)(Math.log(0.78D) / Math.log(0.9D));
  private static final float[] q = new float[101];
  private static final float[] r = new float[101];
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
          q[i1] = (f7 * (f6 * 0.5F + f4) + f8);
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
              r[i1] = (f7 * (f6 * 0.175F + f4 * 0.35F) + f8);
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
    float[] arrayOfFloat = q;
    r[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private static float a(int paramInt)
  {
    if (paramInt > 0) {
      return -2000.0F;
    }
    return 2000.0F;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = 1;
    if ((paramInt1 > paramInt2) && (paramInt1 < paramInt3))
    {
      Log.e("OverScroller", "startAfterEdge called from a valid position");
      this.k = true;
      return;
    }
    int i1;
    if (paramInt1 > paramInt3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = paramInt3;
    } else {
      i2 = paramInt2;
    }
    int i4 = paramInt1 - i2;
    if (i4 * paramInt4 < 0) {
      i3 = 0;
    }
    if (i3 != 0)
    {
      e(paramInt1, i2, paramInt4);
      return;
    }
    if (c(paramInt4) > Math.abs(i4))
    {
      if (i1 == 0) {
        paramInt2 = paramInt1;
      }
      if (i1 != 0) {
        paramInt3 = paramInt1;
      }
      a(paramInt1, paramInt4, paramInt2, paramInt3, this.l);
      return;
    }
    c(paramInt1, i2, paramInt4);
  }
  
  static void a(Context paramContext)
  {
    o = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private double b(int paramInt)
  {
    return Math.log(Math.abs(paramInt) * 0.35F / (this.m * o));
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    float f3 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(f3 * 100.0F);
    if (paramInt1 < 100)
    {
      float f4 = paramInt1 / 100.0F;
      paramInt2 = paramInt1 + 1;
      float f5 = paramInt2 / 100.0F;
      float[] arrayOfFloat = r;
      float f1 = arrayOfFloat[paramInt1];
      float f2 = arrayOfFloat[paramInt2];
      f3 = (f3 - f4) / (f5 - f4);
      this.h = ((int)(this.h * (f1 + f3 * (f2 - f1))));
    }
  }
  
  private double c(int paramInt)
  {
    double d2 = b(paramInt);
    float f1 = p;
    double d3 = f1;
    Double.isNaN(d3);
    double d1 = this.m * o;
    double d4 = f1;
    Double.isNaN(d4);
    d2 = Math.exp(d4 / (d3 - 1.0D) * d2);
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = false;
    this.n = 1;
    this.a = paramInt1;
    this.c = paramInt2;
    paramInt1 -= paramInt2;
    this.f = a(paramInt1);
    this.d = (-paramInt1);
    this.l = Math.abs(paramInt1);
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = this.f;
    Double.isNaN(d2);
    this.h = ((int)(Math.sqrt(d1 * -2.0D / d2) * 1000.0D));
  }
  
  private int d(int paramInt)
  {
    double d1 = b(paramInt);
    double d2 = p;
    Double.isNaN(d2);
    return (int)(Math.exp(d1 / (d2 - 1.0D)) * 1000.0D);
  }
  
  private void d()
  {
    int i1 = this.d;
    float f2 = i1 * i1 / (Math.abs(this.f) * 2.0F);
    float f3 = Math.signum(this.d);
    i1 = this.l;
    float f1 = f2;
    if (f2 > i1)
    {
      f1 = -f3;
      int i2 = this.d;
      this.f = (f1 * i2 * i2 / (i1 * 2.0F));
      f1 = i1;
    }
    this.l = ((int)f1);
    this.n = 2;
    i1 = this.a;
    if (this.d <= 0) {
      f1 = -f1;
    }
    this.c = (i1 + (int)f1);
    this.h = (-(int)(this.d * 1000.0F / this.f));
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    float f2 = -paramInt3;
    float f1 = this.f;
    f2 /= f1;
    double d1 = paramInt3 * paramInt3 / 2.0F / Math.abs(f1) + Math.abs(paramInt2 - paramInt1);
    Double.isNaN(d1);
    double d2 = Math.abs(this.f);
    Double.isNaN(d2);
    f1 = (float)Math.sqrt(d1 * 2.0D / d2);
    this.g -= (int)((f1 - f2) * 1000.0F);
    this.a = paramInt2;
    this.d = ((int)(-this.f * f1));
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt3 == 0) {
      i1 = paramInt1 - paramInt2;
    } else {
      i1 = paramInt3;
    }
    this.f = a(i1);
    d(paramInt1, paramInt2, paramInt3);
    d();
  }
  
  void a()
  {
    this.b = this.c;
    this.k = true;
  }
  
  void a(float paramFloat)
  {
    int i1 = this.a;
    this.b = (i1 + Math.round(paramFloat * (this.c - i1)));
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
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.l = paramInt5;
    this.k = false;
    this.d = paramInt2;
    float f1 = paramInt2;
    this.e = f1;
    this.i = 0;
    this.h = 0;
    this.g = AnimationUtils.currentAnimationTimeMillis();
    this.a = paramInt1;
    this.b = paramInt1;
    if ((paramInt1 <= paramInt4) && (paramInt1 >= paramInt3))
    {
      this.n = 0;
      double d1 = 0.0D;
      if (paramInt2 != 0)
      {
        paramInt5 = d(paramInt2);
        this.i = paramInt5;
        this.h = paramInt5;
        d1 = c(paramInt2);
      }
      double d2 = Math.signum(f1);
      Double.isNaN(d2);
      this.j = ((int)(d1 * d2));
      this.c = (paramInt1 + this.j);
      paramInt1 = this.c;
      if (paramInt1 < paramInt3)
      {
        b(this.a, paramInt1, paramInt3);
        this.c = paramInt3;
      }
      paramInt1 = this.c;
      if (paramInt1 > paramInt4)
      {
        b(this.a, paramInt1, paramInt4);
        this.c = paramInt4;
      }
      return;
    }
    a(paramInt1, paramInt3, paramInt4, paramInt2);
  }
  
  boolean b()
  {
    int i1 = this.n;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          this.g += this.h;
          c(this.c, this.a, 0);
        }
      }
      else {
        return false;
      }
    }
    else
    {
      if (this.h >= this.i) {
        break label118;
      }
      this.a = this.c;
      this.d = ((int)this.e);
      this.f = a(this.d);
      this.g += this.h;
      d();
    }
    c();
    return true;
    label118:
    return false;
  }
  
  boolean c()
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis() - this.g;
    int i1 = this.h;
    if (l1 > i1) {
      return false;
    }
    double d1 = 0.0D;
    int i2 = this.n;
    float f1;
    float f2;
    float f3;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 == 2)
        {
          f1 = (float)l1 / 1000.0F;
          i1 = this.d;
          f2 = i1;
          f3 = this.f;
          this.e = (f2 + f3 * f1);
          d1 = i1 * f1 + f3 * f1 * f1 / 2.0F;
        }
      }
      else
      {
        f1 = (float)l1 / i1;
        f2 = f1 * f1;
        f3 = Math.signum(this.d);
        i1 = this.l;
        d1 = i1 * f3 * (3.0F * f2 - 2.0F * f1 * f2);
        this.e = (f3 * i1 * 6.0F * (-f1 + f2));
      }
    }
    else
    {
      f3 = (float)l1 / this.i;
      i1 = (int)(f3 * 100.0F);
      f1 = 1.0F;
      f2 = 0.0F;
      if (i1 < 100)
      {
        f1 = i1 / 100.0F;
        i2 = i1 + 1;
        f2 = i2 / 100.0F;
        float[] arrayOfFloat = q;
        float f4 = arrayOfFloat[i1];
        f2 = (arrayOfFloat[i2] - f4) / (f2 - f1);
        f1 = f4 + (f3 - f1) * f2;
      }
      i1 = this.j;
      d1 = f1 * i1;
      this.e = (f2 * i1 / this.i * 1000.0F);
    }
    this.b = (this.a + (int)Math.round(d1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.OverScroller.SplineOverScroller
 * JD-Core Version:    0.7.0.1
 */