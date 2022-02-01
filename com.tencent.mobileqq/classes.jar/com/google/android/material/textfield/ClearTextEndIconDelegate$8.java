package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

class ClearTextEndIconDelegate$8
  implements ValueAnimator.AnimatorUpdateListener
{
  ClearTextEndIconDelegate$8(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.c.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.8
 * JD-Core Version:    0.7.0.1
 */