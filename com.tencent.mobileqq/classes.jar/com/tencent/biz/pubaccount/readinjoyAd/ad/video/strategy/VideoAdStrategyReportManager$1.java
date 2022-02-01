package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class VideoAdStrategyReportManager$1
  extends Handler
{
  VideoAdStrategyReportManager$1(VideoAdStrategyReportManager paramVideoAdStrategyReportManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    VideoAdStrategyReportManager.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager.1
 * JD-Core Version:    0.7.0.1
 */