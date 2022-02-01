package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class CircularIndeterminateAnimatorDelegate$1
  extends AnimatorListenerAdapter
{
  CircularIndeterminateAnimatorDelegate$1(CircularIndeterminateAnimatorDelegate paramCircularIndeterminateAnimatorDelegate) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    super.onAnimationRepeat(paramAnimator);
    paramAnimator = this.a;
    CircularIndeterminateAnimatorDelegate.a(paramAnimator, (CircularIndeterminateAnimatorDelegate.a(paramAnimator) + 4) % CircularIndeterminateAnimatorDelegate.a(this.a).a.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
 * JD-Core Version:    0.7.0.1
 */