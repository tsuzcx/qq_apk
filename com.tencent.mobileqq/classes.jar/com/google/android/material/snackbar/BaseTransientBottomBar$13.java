package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;

class BaseTransientBottomBar$13
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseTransientBottomBar$13(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    this.a.b.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.13
 * JD-Core Version:    0.7.0.1
 */