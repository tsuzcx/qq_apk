package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TabLayoutCompat$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayoutCompat$1(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.1
 * JD-Core Version:    0.7.0.1
 */