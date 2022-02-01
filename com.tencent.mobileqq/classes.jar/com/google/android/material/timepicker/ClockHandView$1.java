package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ClockHandView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ClockHandView$1(ClockHandView paramClockHandView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ClockHandView.a(this.a, f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockHandView.1
 * JD-Core Version:    0.7.0.1
 */