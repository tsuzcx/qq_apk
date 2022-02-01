package com.tencent.biz.qqcircle.publish.view;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.biz.qqcircle.publish.util.AnimateUtils;

public class OverScroller
{
  public static int a = 400;
  private int b;
  private final OverScroller.SplineOverScroller c;
  private final OverScroller.SplineOverScroller d;
  private Interpolator e;
  private final boolean f;
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.e = paramInterpolator;
    this.f = paramBoolean;
    this.c = new OverScroller.SplineOverScroller();
    this.d = new OverScroller.SplineOverScroller();
    OverScroller.SplineOverScroller.a(paramContext);
  }
  
  public final void a(float paramFloat)
  {
    this.c.a(paramFloat);
    this.d.a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b = 0;
    this.c.a(paramInt1, paramInt3, paramInt5);
    this.d.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, 1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if ((this.f) && (!a()))
    {
      float f1 = OverScroller.SplineOverScroller.c(this.c);
      float f2 = OverScroller.SplineOverScroller.c(this.d);
      float f3 = paramInt3;
      if (Math.signum(f3) == Math.signum(f1))
      {
        float f4 = paramInt4;
        if (Math.signum(f4) == Math.signum(f2))
        {
          paramInt3 = (int)(f3 + f1);
          paramInt4 = (int)(f4 + f2);
        }
      }
    }
    this.b = paramInt11;
    this.c.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
    this.d.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
  }
  
  public final boolean a()
  {
    return (OverScroller.SplineOverScroller.a(this.c)) && (OverScroller.SplineOverScroller.a(this.d));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool1 = true;
    this.b = 1;
    boolean bool2 = this.c.b(paramInt1, paramInt3, paramInt4);
    boolean bool3 = this.d.b(paramInt2, paramInt5, paramInt6);
    if (!bool2)
    {
      if (bool3) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public final int b()
  {
    return OverScroller.SplineOverScroller.b(this.c);
  }
  
  public boolean c()
  {
    if (a()) {
      return false;
    }
    int i = this.b;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if ((!OverScroller.SplineOverScroller.a(this.c)) && (!this.c.d()) && (!this.c.c())) {
          this.c.a();
        }
        if ((!OverScroller.SplineOverScroller.a(this.d)) && (!this.d.d()) && (!this.d.c()))
        {
          this.d.a();
          return true;
        }
      }
      else
      {
        if ((!OverScroller.SplineOverScroller.a(this.c)) && (!this.c.d()) && (!this.c.b())) {
          this.c.a();
        }
        if ((!OverScroller.SplineOverScroller.a(this.d)) && (!this.d.d()) && (!this.d.b()))
        {
          this.d.a();
          return true;
        }
      }
    }
    else
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - OverScroller.SplineOverScroller.e(this.c);
      i = OverScroller.SplineOverScroller.d(this.c);
      if (l < i)
      {
        float f1 = (float)l / i;
        Interpolator localInterpolator = this.e;
        if (localInterpolator == null) {
          f1 = AnimateUtils.a(f1);
        } else {
          f1 = localInterpolator.getInterpolation(f1);
        }
        if (!OverScroller.SplineOverScroller.a(this.c)) {
          this.c.b(f1);
        }
        if (!OverScroller.SplineOverScroller.a(this.d))
        {
          this.d.b(f1);
          return true;
        }
      }
      else
      {
        d();
      }
    }
    return true;
  }
  
  public void d()
  {
    this.c.a();
    this.d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.OverScroller
 * JD-Core Version:    0.7.0.1
 */