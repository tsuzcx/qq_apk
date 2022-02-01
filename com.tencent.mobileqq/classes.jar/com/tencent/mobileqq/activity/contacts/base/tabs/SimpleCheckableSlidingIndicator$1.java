package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SimpleCheckableSlidingIndicator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SimpleCheckableSlidingIndicator$1(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.1
 * JD-Core Version:    0.7.0.1
 */