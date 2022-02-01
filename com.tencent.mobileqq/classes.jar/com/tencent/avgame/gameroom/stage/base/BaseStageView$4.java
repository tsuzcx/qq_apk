package com.tencent.avgame.gameroom.stage.base;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class BaseStageView$4
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  BaseStageView$4(BaseStageView paramBaseStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "COUNT_DOWN_5S_JSON onLoad lottieDrawable = " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.a = paramLottieDrawable;
      BaseStageView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.4
 * JD-Core Version:    0.7.0.1
 */