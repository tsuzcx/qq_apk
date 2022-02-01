package com.google.android.material.transition;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MaterialContainerTransform$1
  implements ValueAnimator.AnimatorUpdateListener
{
  MaterialContainerTransform$1(MaterialContainerTransform paramMaterialContainerTransform, MaterialContainerTransform.TransitionDrawable paramTransitionDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MaterialContainerTransform.TransitionDrawable.a(this.a, paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.MaterialContainerTransform.1
 * JD-Core Version:    0.7.0.1
 */