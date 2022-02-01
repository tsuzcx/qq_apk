package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class VideoAdExposureManager$1
  implements Runnable
{
  VideoAdExposureManager$1(VideoAdExposureManager paramVideoAdExposureManager, int paramInt1, int paramInt2, AdRequestData paramAdRequestData) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchAnotherAd refreshChannelAdvertisementFormServer reqType=");
      localStringBuilder.append(this.a);
      QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
    }
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(this.b, this.a, 0, 10000, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */