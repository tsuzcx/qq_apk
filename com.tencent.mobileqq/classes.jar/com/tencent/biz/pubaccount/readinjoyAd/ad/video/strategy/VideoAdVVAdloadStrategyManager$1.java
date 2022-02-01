package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoAdVVAdloadStrategyManager$1
  extends Handler
{
  VideoAdVVAdloadStrategyManager$1(VideoAdVVAdloadStrategyManager paramVideoAdVVAdloadStrategyManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 4097) {
      return;
    }
    paramMessage = this.a;
    VideoAdVVAdloadStrategyManager.a(paramMessage, VideoAdVVAdloadStrategyManager.a(paramMessage) + 500L);
    paramMessage = new StringBuilder();
    paramMessage.append("start record playDurationTime:  ");
    paramMessage.append(VideoAdVVAdloadStrategyManager.a(this.a));
    QLog.d("VideoAdVVAdloadStrategyManager", 2, paramMessage.toString());
    this.a.a();
    paramMessage = this.a;
    VideoAdVVAdloadStrategyManager.a(paramMessage, VideoAdVVAdloadStrategyManager.a(paramMessage), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager.1
 * JD-Core Version:    0.7.0.1
 */