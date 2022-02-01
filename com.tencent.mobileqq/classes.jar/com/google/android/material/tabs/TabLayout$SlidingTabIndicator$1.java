package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import androidx.annotation.NonNull;

class TabLayout$SlidingTabIndicator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayout$SlidingTabIndicator$1(TabLayout.SlidingTabIndicator paramSlidingTabIndicator, View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    TabLayout.SlidingTabIndicator.a(this.c, this.a, this.b, paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
 * JD-Core Version:    0.7.0.1
 */