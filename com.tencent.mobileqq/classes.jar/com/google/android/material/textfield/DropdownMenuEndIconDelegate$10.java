package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

class DropdownMenuEndIconDelegate$10
  implements ValueAnimator.AnimatorUpdateListener
{
  DropdownMenuEndIconDelegate$10(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
 * JD-Core Version:    0.7.0.1
 */