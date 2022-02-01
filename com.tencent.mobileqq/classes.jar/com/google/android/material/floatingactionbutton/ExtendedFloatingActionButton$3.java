package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ExtendedFloatingActionButton$3
  extends AnimatorListenerAdapter
{
  private boolean d;
  
  ExtendedFloatingActionButton$3(ExtendedFloatingActionButton paramExtendedFloatingActionButton, MotionStrategy paramMotionStrategy, ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.d = true;
    this.a.e();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.d();
    if (!this.d) {
      this.a.a(this.b);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a(paramAnimator);
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
 * JD-Core Version:    0.7.0.1
 */