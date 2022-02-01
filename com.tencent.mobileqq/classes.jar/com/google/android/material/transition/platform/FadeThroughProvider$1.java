package com.google.android.material.transition.platform;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class FadeThroughProvider$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FadeThroughProvider$1(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(TransitionUtils.a(this.jdField_a_of_type_Float, this.b, this.c, this.d, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.FadeThroughProvider.1
 * JD-Core Version:    0.7.0.1
 */