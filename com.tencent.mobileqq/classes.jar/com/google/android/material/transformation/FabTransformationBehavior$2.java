package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class FabTransformationBehavior$2
  implements ValueAnimator.AnimatorUpdateListener
{
  FabTransformationBehavior$2(FabTransformationBehavior paramFabTransformationBehavior, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.2
 * JD-Core Version:    0.7.0.1
 */