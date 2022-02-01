package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SimpleSlidingIndicator$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SimpleSlidingIndicator$3(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.3
 * JD-Core Version:    0.7.0.1
 */