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
    if (CountDownClockNumLottieView.a(this.a) != 0.0F)
    {
      paramValueAnimator = this.a;
      CountDownClockNumLottieView.a(paramValueAnimator, CountDownClockNumLottieView.b(paramValueAnimator) - (int)(CountDownClockNumLottieView.c(this.a) / CountDownClockNumLottieView.a(this.a)));
    }
    if ((CountDownClockNumLottieView.c(this.a) == 360) && (CountDownClockNumLottieView.d(this.a) != null) && (this.a.getVisibility() == 0)) {
      CountDownClockNumLottieView.d(this.a).a();
    }
    if ((CountDownClockNumLottieView.c(this.a) == 360) && (this.a.b != null))
    {
      if (this.a.b.isRunning()) {
        this.a.b.stop();
      }
      this.a.b.setMinProgress(0.0F);
      this.a.b.setProgress(0.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView.2
 * JD-Core Version:    0.7.0.1
 */