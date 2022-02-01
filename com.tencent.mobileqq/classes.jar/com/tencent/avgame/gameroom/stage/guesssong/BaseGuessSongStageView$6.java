package com.tencent.avgame.gameroom.stage.guesssong;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class BaseGuessSongStageView$6
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  BaseGuessSongStageView$6(BaseGuessSongStageView paramBaseGuessSongStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessSongStageView", 2, "onLoad lottieDrawable = " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.a = paramLottieDrawable;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView.6
 * JD-Core Version:    0.7.0.1
 */