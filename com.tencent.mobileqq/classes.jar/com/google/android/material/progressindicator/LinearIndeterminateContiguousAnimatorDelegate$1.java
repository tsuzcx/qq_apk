package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class LinearIndeterminateContiguousAnimatorDelegate$1
  extends AnimatorListenerAdapter
{
  LinearIndeterminateContiguousAnimatorDelegate$1(LinearIndeterminateContiguousAnimatorDelegate paramLinearIndeterminateContiguousAnimatorDelegate) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    super.onAnimationRepeat(paramAnimator);
    paramAnimator = this.a;
    LinearIndeterminateContiguousAnimatorDelegate.a(paramAnimator, (LinearIndeterminateContiguousAnimatorDelegate.a(paramAnimator) + 1) % LinearIndeterminateContiguousAnimatorDelegate.a(this.a).a.length);
    LinearIndeterminateContiguousAnimatorDelegate.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.1
 * JD-Core Version:    0.7.0.1
 */