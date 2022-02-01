package com.google.android.material.transition.platform;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MaterialContainerTransform$1
  implements ValueAnimator.AnimatorUpdateListener
{
  MaterialContainerTransform$1(MaterialContainerTransform paramMaterialContainerTransform, MaterialContainerTransform.TransitionDrawable paramTransitionDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MaterialContainerTransform.TransitionDrawable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$TransitionDrawable, paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransform.1
 * JD-Core Version:    0.7.0.1
 */