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
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    VideoAdVVAdloadStrategyManager.a(this.a, VideoAdVVAdloadStrategyManager.a(this.a) + 500L);
    QLog.d("VideoAdVVAdloadStrategyManager", 2, "start record playDurationTime:  " + VideoAdVVAdloadStrategyManager.a(this.a));
    this.a.a();
    VideoAdVVAdloadStrategyManager.a(this.a, VideoAdVVAdloadStrategyManager.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager.1
 * JD-Core Version:    0.7.0.1
 */