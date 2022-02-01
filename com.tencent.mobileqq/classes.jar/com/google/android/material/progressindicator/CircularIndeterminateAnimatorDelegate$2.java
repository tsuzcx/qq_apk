package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

class CircularIndeterminateAnimatorDelegate$2
  extends AnimatorListenerAdapter
{
  CircularIndeterminateAnimatorDelegate$2(CircularIndeterminateAnimatorDelegate paramCircularIndeterminateAnimatorDelegate) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.b();
    this.a.a.onAnimationEnd(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
 * JD-Core Version:    0.7.0.1
 */