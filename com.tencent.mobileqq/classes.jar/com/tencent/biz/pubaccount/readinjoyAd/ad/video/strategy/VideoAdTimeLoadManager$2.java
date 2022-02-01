package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;

class VideoAdTimeLoadManager$2
  implements Runnable
{
  VideoAdTimeLoadManager$2(VideoAdTimeLoadManager paramVideoAdTimeLoadManager, AdRequestData paramAdRequestData) {}
  
  public void run()
  {
    ReadInJoyAdLog.a("VideoAdTimeLoadManager", "preLoadAd refreshChannelAdvertisementFormServer");
    ReadInJoyLogicEngine.a().a(88888888, 5, 0, 10000, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.2
 * JD-Core Version:    0.7.0.1
 */