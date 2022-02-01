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
    this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$BaseBehavior.a(this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout, this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
 * JD-Core Version:    0.7.0.1
 */