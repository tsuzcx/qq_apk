package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;

public class AnimationPoint
  extends View
{
  protected long a;
  protected long b;
  protected int c;
  protected long d;
  protected long e;
  protected Paint f = new Paint();
  protected boolean g = false;
  protected int h;
  protected int i;
  AccelerateDecelerateInterpolator j;
  protected int k;
  protected Animation.AnimationListener l;
  protected Handler m = new Handler(Looper.getMainLooper());
  protected boolean n = false;
  private Runnable o = new AnimationPoint.1(this);
  
  public AnimationPoint(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(-1);
    this.e = 1000L;
    this.a = (this.e * 2L);
    this.b = 2000L;
    this.j = new AccelerateDecelerateInterpolator();
  }
  
  protected int a(long paramLong)
  {
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = this.j;
    long l1 = this.e;
    float f1 = localAccelerateDecelerateInterpolator.getInterpolation((float)(paramLong % l1) / (float)l1);
    int i1;
    if (this.g) {
      i1 = this.i;
    } else {
      i1 = this.h;
    }
    i1 -= this.c * 2;
    if (paramLong > this.e) {
      this.k = (this.c + (int)(i1 * f1));
    } else {
      this.k = (this.c + i1 - (int)(i1 * f1));
    }
    return this.k;
  }
  
  public void a()
  {
    this.n = false;
    this.d = SystemClock.uptimeMillis();
    this.h = super.getWidth();
    this.i = super.getHeight();
    Animation.AnimationListener localAnimationListener = this.l;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(null);
    }
    this.m.post(this.o);
  }
  
  protected int b(long paramLong)
  {
    if (paramLong < this.e) {
      return this.k + this.c / 2;
    }
    return this.k - this.c / 2;
  }
  
  public void b()
  {
    this.m.removeCallbacks(this.o);
    this.n = true;
  }
  
  protected int c(long paramLong)
  {
    if (paramLong < this.e) {
      return this.k + this.c;
    }
    return this.k - this.c;
  }
  
  protected float d(long paramLong)
  {
    long l1 = this.e;
    paramLong %= l1;
    float f1;
    if (paramLong < l1 * 16L / 100L) {
      f1 = (float)paramLong * 1.0F;
    }
    for (paramLong = l1 * 16L / 100L;; paramLong = l1 * 40L / 100L)
    {
      return f1 / (float)paramLong;
      if (paramLong < 60L * l1 / 100L) {
        return 1.0F;
      }
      f1 = (float)(l1 - paramLong) * 1.0F;
    }
  }
  
  protected float e(long paramLong)
  {
    long l1 = this.e;
    paramLong %= l1;
    if (paramLong < l1 * 16L / 100L) {
      return 0.0F;
    }
    float f1;
    if (paramLong < 24L * l1 / 100L) {
      f1 = (float)(paramLong - 16L * l1 / 100L) * 0.4F;
    }
    for (paramLong = l1 * 8L / 100L;; paramLong = l1 * 36L / 100L)
    {
      return f1 / (float)paramLong;
      if (paramLong >= l1 * 60L / 100L) {
        break;
      }
      f1 = (float)(60L * l1 / 100L - paramLong) * 0.4F;
    }
    return 0.0F;
  }
  
  protected float f(long paramLong)
  {
    long l1 = this.e;
    paramLong %= l1;
    if (paramLong < l1 * 24L / 100L) {
      return 0.0F;
    }
    float f1;
    if (paramLong < 36L * l1 / 100L) {
      f1 = (float)(paramLong - 24L * l1 / 100L) * 0.2F;
    }
    for (paramLong = l1 * 12L / 100L;; paramLong = l1 * 24L / 100L)
    {
      return f1 / (float)paramLong;
      if (paramLong >= l1 * 60L / 100L) {
        break;
      }
      f1 = (float)(60L * l1 / 100L - paramLong) * 0.2F;
    }
    return 0.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.h = super.getWidth();
    this.i = super.getHeight();
    int i2 = this.h / 2;
    int i3 = this.i / 2;
    long l1 = (SystemClock.uptimeMillis() - this.d) % this.a;
    int i4 = a(l1);
    int i5 = b(l1);
    int i6 = c(l1);
    float f1 = d(l1);
    float f2 = e(l1);
    float f3 = f(l1);
    if (this.c == 0)
    {
      int i1;
      if (this.g) {
        i1 = this.h;
      } else {
        i1 = this.i;
      }
      this.c = (i1 / 2);
    }
    if (f3 != 0.0F)
    {
      this.f.setAlpha((int)(f3 * 255.0F));
      if (this.g) {
        paramCanvas.drawCircle(i2, i6, this.c, this.f);
      } else {
        paramCanvas.drawCircle(i6, i3, this.c, this.f);
      }
    }
    if (f2 != 0.0F)
    {
      this.f.setAlpha((int)(f2 * 255.0F));
      if (this.g) {
        paramCanvas.drawCircle(i2, i5, this.c, this.f);
      } else {
        paramCanvas.drawCircle(i5, i3, this.c, this.f);
      }
    }
    if (f1 != 0.0F)
    {
      this.f.setAlpha((int)(f1 * 255.0F));
      if (this.g)
      {
        paramCanvas.drawCircle(i2, i4, this.c, this.f);
        return;
      }
      paramCanvas.drawCircle(i4, i3, this.c, this.f);
    }
  }
  
  public void setDuration(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setIsVertical(boolean paramBoolean)
  {
    this.g = paramBoolean;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      int i1 = localLayoutParams.width;
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.height = i1;
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setLoopTime(long paramLong)
  {
    this.a = paramLong;
    this.e = (paramLong / 2L);
  }
  
  public void setOnAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.l = paramAnimationListener;
  }
  
  public void setRadius(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint
 * JD-Core Version:    0.7.0.1
 */