package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ReadinjoySlidingIndicator$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadinjoySlidingIndicator$2(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ReadinjoySlidingIndicator.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator.2
 * JD-Core Version:    0.7.0.1
 */