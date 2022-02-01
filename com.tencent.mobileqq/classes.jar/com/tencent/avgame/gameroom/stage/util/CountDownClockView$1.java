package com.tencent.avgame.gameroom.stage.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CountDownClockView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CountDownClockView$1(CountDownClockView paramCountDownClockView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    CountDownClockView.a(this.a, i);
    if ((CountDownClockView.a(this.a) == 360) && (CountDownClockView.a(this.a) != null)) {
      CountDownClockView.a(this.a).a();
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockView.1
 * JD-Core Version:    0.7.0.1
 */