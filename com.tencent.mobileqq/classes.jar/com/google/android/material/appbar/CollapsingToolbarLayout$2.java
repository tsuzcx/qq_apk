package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;

class CollapsingToolbarLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CollapsingToolbarLayout$2(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    this.a.setScrimAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout.2
 * JD-Core Version:    0.7.0.1
 */