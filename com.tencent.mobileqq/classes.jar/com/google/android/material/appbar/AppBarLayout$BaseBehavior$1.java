package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class AppBarLayout$BaseBehavior$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBarLayout$BaseBehavior$1(AppBarLayout.BaseBehavior paramBaseBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    this.c.a_(this.a, this.b, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
 * JD-Core Version:    0.7.0.1
 */