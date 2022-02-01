package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class HeartCombolEffectView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  HeartCombolEffectView$3(HeartCombolEffectView paramHeartCombolEffectView, HeartCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.j = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.a.o) && (this.a.j > 0.0F)) {
      this.a.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView.3
 * JD-Core Version:    0.7.0.1
 */