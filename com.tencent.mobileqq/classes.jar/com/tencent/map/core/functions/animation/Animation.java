package com.tencent.map.core.functions.animation;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public abstract class Animation
{
  private boolean a = false;
  protected Animation.InnerAnimationListener animationListener = null;
  protected Animation.SetAnimatePropertyListener animationProperty = null;
  private boolean b = false;
  private boolean c = false;
  private Interpolator d = new LinearInterpolator();
  protected long iDuration = 1500L;
  protected long ltimeStart = 0L;
  
  public void drawAnimation()
  {
    Animation.InnerAnimationListener localInnerAnimationListener;
    if (!this.a)
    {
      if (!this.c)
      {
        localInnerAnimationListener = this.animationListener;
        if (localInnerAnimationListener != null) {
          localInnerAnimationListener.onAnimationFinish();
        }
      }
      return;
    }
    float f = (float)(SystemClock.uptimeMillis() - this.ltimeStart) / (float)this.iDuration;
    if (f > 1.0F)
    {
      this.a = false;
      performAnimation(1.0F, this.d);
      localInnerAnimationListener = this.animationListener;
      if (localInnerAnimationListener != null) {
        localInnerAnimationListener.onAnimationFinish();
      }
      this.c = true;
      return;
    }
    performAnimation(f, this.d);
  }
  
  public Interpolator getInterpolator()
  {
    return this.d;
  }
  
  public boolean isEnded()
  {
    return this.c;
  }
  
  public boolean isRunning()
  {
    return this.a;
  }
  
  public boolean isStarted()
  {
    return this.b;
  }
  
  protected abstract void performAnimation(float paramFloat, Interpolator paramInterpolator);
  
  public void setAnimationListener(Animation.InnerAnimationListener paramInnerAnimationListener)
  {
    this.animationListener = paramInnerAnimationListener;
  }
  
  public void setAnimationProperty(Animation.SetAnimatePropertyListener paramSetAnimatePropertyListener)
  {
    this.animationProperty = paramSetAnimatePropertyListener;
  }
  
  public void setDuration(long paramLong)
  {
    this.iDuration = paramLong;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public boolean startAnimation()
  {
    if (this.iDuration <= 0L) {
      return false;
    }
    this.b = true;
    this.ltimeStart = SystemClock.uptimeMillis();
    this.a = true;
    Animation.InnerAnimationListener localInnerAnimationListener = this.animationListener;
    if (localInnerAnimationListener != null) {
      localInnerAnimationListener.onAnimationStart();
    }
    return true;
  }
  
  public void stopAnimation()
  {
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.Animation
 * JD-Core Version:    0.7.0.1
 */