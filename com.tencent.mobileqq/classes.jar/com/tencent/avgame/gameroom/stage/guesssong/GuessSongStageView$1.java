package com.tencent.avgame.gameroom.stage.guesssong;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class GuessSongStageView$1
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  GuessSongStageView$1(GuessSongStageView paramGuessSongStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoad lottieDrawable = ");
      ((StringBuilder)localObject).append(paramLottieDrawable);
      QLog.d("GuessSongStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLottieDrawable != null)
    {
      localObject = this.a;
      ((GuessSongStageView)localObject).p = paramLottieDrawable;
      ((GuessSongStageView)localObject).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView.1
 * JD-Core Version:    0.7.0.1
 */