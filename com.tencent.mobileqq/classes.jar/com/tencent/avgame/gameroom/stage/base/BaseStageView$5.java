package com.tencent.avgame.gameroom.stage.base;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class BaseStageView$5
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  BaseStageView$5(BaseStageView paramBaseStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "onLoad " + paramLottieDrawable);
    }
    if (paramLottieDrawable != null)
    {
      this.a.b = paramLottieDrawable;
      this.a.b.addAnimatorListener(new BaseStageView.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.5
 * JD-Core Version:    0.7.0.1
 */