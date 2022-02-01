package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

class ClearTextEndIconDelegate$9
  implements ValueAnimator.AnimatorUpdateListener
{
  ClearTextEndIconDelegate$9(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.c.setScaleX(f);
    this.a.c.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.9
 * JD-Core Version:    0.7.0.1
 */