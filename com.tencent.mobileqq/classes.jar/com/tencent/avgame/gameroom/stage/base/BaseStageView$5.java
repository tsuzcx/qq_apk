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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoad ");
      ((StringBuilder)localObject).append(paramLottieDrawable);
      QLog.d("BaseStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLottieDrawable != null)
    {
      localObject = this.a;
      ((BaseStageView)localObject).b = paramLottieDrawable;
      ((BaseStageView)localObject).b.addAnimatorListener(new BaseStageView.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.5
 * JD-Core Version:    0.7.0.1
 */