package com.tencent.biz.qqcircle.richframework.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class TabLayoutCompat$SlidingTabStrip$2
  extends AnimatorListenerAdapter
{
  TabLayoutCompat$SlidingTabStrip$2(TabLayoutCompat.SlidingTabStrip paramSlidingTabStrip, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    paramAnimator.a = this.a;
    paramAnimator.b = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.SlidingTabStrip.2
 * JD-Core Version:    0.7.0.1
 */