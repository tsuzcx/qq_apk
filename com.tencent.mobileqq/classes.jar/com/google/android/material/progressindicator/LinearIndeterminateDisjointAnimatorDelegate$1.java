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
    if (LinearIndeterminateDisjointAnimatorDelegate.a(this.a))
    {
      LinearIndeterminateDisjointAnimatorDelegate.a(this.a).setRepeatCount(-1);
      this.a.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback.onAnimationEnd(this.a.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable);
      LinearIndeterminateDisjointAnimatorDelegate.b(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    super.onAnimationRepeat(paramAnimator);
    paramAnimator = this.a;
    LinearIndeterminateDisjointAnimatorDelegate.a(paramAnimator, (LinearIndeterminateDisjointAnimatorDelegate.a(paramAnimator) + 1) % LinearIndeterminateDisjointAnimatorDelegate.a(this.a).a.length);
    LinearIndeterminateDisjointAnimatorDelegate.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
 * JD-Core Version:    0.7.0.1
 */