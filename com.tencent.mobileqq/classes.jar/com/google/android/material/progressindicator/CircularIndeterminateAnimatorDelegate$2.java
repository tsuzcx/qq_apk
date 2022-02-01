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
    this.a.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback.onAnimationEnd(this.a.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
 * JD-Core Version:    0.7.0.1
 */