package com.tencent.biz.richframework.animation.support;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper
  implements Animator.AnimatorListener
{
  final AnimatorListenerCompat a;
  final ValueAnimatorCompat b;
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c(this.b);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b(this.b);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.d(this.b);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a(this.b);
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.support.HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper
 * JD-Core Version:    0.7.0.1
 */