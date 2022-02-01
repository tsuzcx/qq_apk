package com.tencent.avgame.gameroom.stage.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class CountDownClockNumLottieView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CountDownClockNumLottieView$2(CountDownClockNumLottieView paramCountDownClockNumLottieView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    CountDownClockNumLottieView.a(this.a, paramValueAnimator.intValue());
    if (CountDownClockNumLottieView.a(this.a) != 0.0F) {
      CountDownClockNumLottieView.a(this.a, CountDownClockNumLottieView.a(this.a) - (int)(CountDownClockNumLottieView.a(this.a) / CountDownClockNumLottieView.a(this.a)));
    }
    if ((CountDownClockNumLottieView.a(this.a) == 360) && (CountDownClockNumLottieView.a(this.a) != null) && (this.a.getVisibility() == 0)) {
      CountDownClockNumLottieView.a(this.a).a();
    }
    if ((CountDownClockNumLottieView.a(this.a) == 360) && (this.a.a != null))
    {
      if (this.a.a.isRunning()) {
        this.a.a.stop();
      }
      this.a.a.setMinProgress(0.0F);
      this.a.a.setProgress(0.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView.2
 * JD-Core Version:    0.7.0.1
 */