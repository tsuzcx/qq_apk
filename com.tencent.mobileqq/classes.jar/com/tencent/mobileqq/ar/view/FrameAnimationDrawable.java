package com.tencent.mobileqq.ar.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class FrameAnimationDrawable
  implements Animatable
{
  private final int[] a;
  private int b;
  private int c;
  private ValueAnimator d;
  private ValueAnimator.AnimatorUpdateListener e;
  private Animator.AnimatorListener f;
  private ImageView g;
  private boolean h;
  
  public FrameAnimationDrawable(int paramInt1, int[] paramArrayOfInt, ImageView paramImageView, int paramInt2)
  {
    this.a = paramArrayOfInt;
    this.g = paramImageView;
    if (paramArrayOfInt.length > 0)
    {
      this.g.setImageResource(paramArrayOfInt[paramInt2]);
      this.b = paramInt2;
      this.c = paramInt2;
      a();
      return;
    }
    throw new RuntimeException(" FrameAnimDrawable RES_IDS can not empty !!!");
  }
  
  public FrameAnimationDrawable(int[] paramArrayOfInt, ImageView paramImageView, int paramInt)
  {
    this(0, paramArrayOfInt, paramImageView, paramInt);
  }
  
  private void a()
  {
    this.d = ValueAnimator.ofInt(new int[] { this.a.length - 1 });
    this.d.setInterpolator(new LinearInterpolator());
    this.d.setDuration(400L);
    this.e = new FrameAnimationDrawable.1(this);
    this.f = new FrameAnimationDrawable.2(this);
  }
  
  private void b(Animator.AnimatorListener paramAnimatorListener)
  {
    this.d.addUpdateListener(this.e);
    if (paramAnimatorListener != null) {
      this.d.addListener(paramAnimatorListener);
    }
    this.d.start();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if (this.h)
    {
      paramInt %= this.a.length;
    }
    else
    {
      int[] arrayOfInt = this.a;
      paramInt = arrayOfInt.length - paramInt % arrayOfInt.length - 1;
    }
    this.g.setImageResource(this.a[paramInt]);
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.d.isStarted()) {
      return;
    }
    b(paramAnimatorListener);
  }
  
  public void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    stop();
    this.h = paramBoolean;
    if (paramBoolean) {
      this.c = (this.a.length - 1);
    } else {
      this.c = 0;
    }
    a(paramAnimatorListener);
  }
  
  public boolean isRunning()
  {
    return this.d.isRunning();
  }
  
  public void start()
  {
    b(null);
  }
  
  public void stop()
  {
    ValueAnimator localValueAnimator = this.d;
    if ((localValueAnimator != null) && (localValueAnimator.isStarted())) {
      this.d.end();
    }
    localValueAnimator = this.d;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.d.removeAllListeners();
    }
    this.b = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.FrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */