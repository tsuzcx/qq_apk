package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import androidx.annotation.NonNull;

class TextScale$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TextScale$1(TextScale paramTextScale, TextView paramTextView) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidWidgetTextView.setScaleX(f);
    this.jdField_a_of_type_AndroidWidgetTextView.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.TextScale.1
 * JD-Core Version:    0.7.0.1
 */