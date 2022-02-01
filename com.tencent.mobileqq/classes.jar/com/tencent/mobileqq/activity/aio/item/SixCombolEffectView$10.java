package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class SixCombolEffectView$10
  implements ValueAnimator.AnimatorUpdateListener
{
  SixCombolEffectView$10(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.a.o) && (this.a.h < 0.52F)) {
      this.a.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.10
 * JD-Core Version:    0.7.0.1
 */