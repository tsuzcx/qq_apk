package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

class LinearIndeterminateDisjointAnimatorDelegate$1
  extends AnimatorListenerAdapter
{
  LinearIndeterminateDisjointAnimatorDelegate$1(LinearIndeterminateDisjointAnimatorDelegate paramLinearIndeterminateDisjointAnimatorDelegate) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (LinearIndeterminateDisjointAnimatorDelegate.c(this.a))
    {
      LinearIndeterminateDisjointAnimatorDelegate.d(this.a).setRepeatCount(-1);
      this.a.a.onAnimationEnd(this.a.b);
      LinearIndeterminateDisjointAnimatorDelegate.b(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    super.onAnimationRepeat(paramAnimator);
    paramAnimator = this.a;
    LinearIndeterminateDisjointAnimatorDelegate.a(paramAnimator, (LinearIndeterminateDisjointAnimatorDelegate.a(paramAnimator) + 1) % LinearIndeterminateDisjointAnimatorDelegate.b(this.a).c.length);
    LinearIndeterminateDisjointAnimatorDelegate.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
 * JD-Core Version:    0.7.0.1
 */