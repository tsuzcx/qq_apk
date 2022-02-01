package com.tencent.avgame.gameroom.stage.util;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class CountDownClockNumLottieView$3
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  CountDownClockNumLottieView$3(CountDownClockNumLottieView paramCountDownClockNumLottieView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CountDownClockNumLottieView", 2, "onLoad lottieDrawable = " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null) {
      this.a.a = paramLottieDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView.3
 * JD-Core Version:    0.7.0.1
 */