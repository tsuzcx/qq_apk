package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SixCombolEffectView$13
  implements ValueAnimator.AnimatorUpdateListener
{
  SixCombolEffectView$13(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.i = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.13
 * JD-Core Version:    0.7.0.1
 */