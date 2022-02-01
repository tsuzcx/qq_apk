package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SixCombolEffectView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SixCombolEffectView$2(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.2
 * JD-Core Version:    0.7.0.1
 */