package com.tencent.avgame.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class AvGameLoadingActivity$4
  implements AVGameLottieHelper.LottieDrawableLoadedListener
{
  AvGameLoadingActivity$4(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.obj = paramLottieDrawable;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.4
 * JD-Core Version:    0.7.0.1
 */