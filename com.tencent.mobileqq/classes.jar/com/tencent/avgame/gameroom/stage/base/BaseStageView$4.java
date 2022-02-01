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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("COUNT_DOWN_5S_JSON onLoad lottieDrawable = ");
      ((StringBuilder)localObject).append(paramLottieDrawable);
      QLog.d("BaseStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLottieDrawable != null)
    {
      localObject = this.a;
      ((BaseStageView)localObject).a = paramLottieDrawable;
      BaseStageView.a((BaseStageView)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView.4
 * JD-Core Version:    0.7.0.1
 */