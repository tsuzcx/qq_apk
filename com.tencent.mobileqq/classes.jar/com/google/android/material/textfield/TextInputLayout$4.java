package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CollapsingTextHelper;

class TextInputLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  TextInputLayout$4(TextInputLayout paramTextInputLayout) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    this.a.c.b(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout.4
 * JD-Core Version:    0.7.0.1
 */