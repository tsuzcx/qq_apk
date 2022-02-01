package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class XViewPager$4
  implements ValueAnimator.AnimatorUpdateListener
{
  XViewPager$4(XViewPager paramXViewPager) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.scrollTo(i, 0);
    XViewPager.b(this.a, i);
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.4
 * JD-Core Version:    0.7.0.1
 */