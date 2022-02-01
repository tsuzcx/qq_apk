package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

class AppBarLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBarLayout$2(AppBarLayout paramAppBarLayout, MaterialShapeDrawable paramMaterialShapeDrawable) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    this.a.r(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.2
 * JD-Core Version:    0.7.0.1
 */