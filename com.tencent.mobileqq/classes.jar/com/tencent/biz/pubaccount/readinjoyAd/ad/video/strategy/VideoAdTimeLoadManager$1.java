package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

class VideoAdTimeLoadManager$1
  extends Handler
{
  VideoAdTimeLoadManager$1(VideoAdTimeLoadManager paramVideoAdTimeLoadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    VideoAdTimeLoadManager.a(this.a).set(1);
    VideoAdTimeLoadManager.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.1
 * JD-Core Version:    0.7.0.1
 */