package com.tencent.av.opengl.ui;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller
{
  private int a;
  private final OverScroller.SplineOverScroller b;
  private final OverScroller.SplineOverScroller c;
  private Interpolator d;
  private final boolean e;
  
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
    this.d = paramInterpolator;
    this.e = paramBoolean;
    this.b = new OverScroller.SplineOverScroller();
    this.c = new OverScroller.SplineOverScroller();
    OverScroller.SplineOverScroller.a(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = 0;
    this.b.a(paramInt1, paramInt3, paramInt5);
    this.c.a(paramInt2, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if ((this.e) && (!a()))
    {
      float f1 = OverScroller.SplineOverScroller.c(this.b);
      float f2 = OverScroller.SplineOverScroller.c(this.c);
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
    this.a = 1;
    this.b.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
    this.c.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
  }
  
  public final void a(boolean paramBoolean)
  {
    OverScroller.SplineOverScroller.a(this.b, OverScroller.SplineOverScroller.a(this.c, paramBoolean));
  }
  
  public final boolean a()
  {
    return (OverScroller.SplineOverScroller.a(this.b)) && (OverScroller.SplineOverScroller.a(this.c));
  }
  
  public final int b()
  {
    return OverScroller.SplineOverScroller.b(this.b);
  }
  
  public final int c()
  {
    return OverScroller.SplineOverScroller.d(this.b);
  }
  
  public boolean d()
  {
    if (a()) {
      return false;
    }
    int i = this.a;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if ((!OverScroller.SplineOverScroller.a(this.b)) && (!this.b.c()) && (!this.b.b())) {
        this.b.a();
      }
      if ((!OverScroller.SplineOverScroller.a(this.c)) && (!this.c.c()) && (!this.c.b()))
      {
        this.c.a();
        return true;
      }
    }
    else
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - OverScroller.SplineOverScroller.f(this.b);
      i = OverScroller.SplineOverScroller.e(this.b);
      if (l < i)
      {
        float f = (float)l / i;
        Interpolator localInterpolator = this.d;
        if (localInterpolator == null) {
          f = Scroller.a(f);
        } else {
          f = localInterpolator.getInterpolation(f);
        }
        this.b.a(f);
        this.c.a(f);
        return true;
      }
      e();
    }
    return true;
  }
  
  public void e()
  {
    this.b.a();
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.OverScroller
 * JD-Core Version:    0.7.0.1
 */