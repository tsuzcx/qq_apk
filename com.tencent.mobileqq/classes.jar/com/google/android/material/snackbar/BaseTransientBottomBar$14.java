package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;

class BaseTransientBottomBar$14
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseTransientBottomBar$14(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setScaleX(f);
    this.a.a.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.14
 * JD-Core Version:    0.7.0.1
 */