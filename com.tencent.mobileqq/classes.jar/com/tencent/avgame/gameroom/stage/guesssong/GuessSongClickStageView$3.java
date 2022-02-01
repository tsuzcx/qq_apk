package com.tencent.avgame.gameroom.stage.guesssong;

import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class GuessSongClickStageView$3
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  GuessSongClickStageView$3(GuessSongClickStageView paramGuessSongClickStageView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoad lottieDrawable = ");
      ((StringBuilder)localObject).append(paramLottieDrawable);
      QLog.d("GuessSongClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLottieDrawable != null)
    {
      localObject = this.a;
      ((GuessSongClickStageView)localObject).a = paramLottieDrawable;
      ((GuessSongClickStageView)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView.3
 * JD-Core Version:    0.7.0.1
 */