package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;

class VideoAdTimeLoadManager$2
  implements Runnable
{
  VideoAdTimeLoadManager$2(VideoAdTimeLoadManager paramVideoAdTimeLoadManager, AdRequestData paramAdRequestData) {}
  
  public void run()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoAdTimeLoadManager", "preLoadAd refreshChannelAdvertisementFormServer");
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(88888888, 5, 0, 10000, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.2
 * JD-Core Version:    0.7.0.1
 */