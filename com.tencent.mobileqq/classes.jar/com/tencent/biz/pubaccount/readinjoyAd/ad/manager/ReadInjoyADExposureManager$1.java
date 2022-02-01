package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInjoyADExposureManager$1
  implements Runnable
{
  ReadInjoyADExposureManager$1(ReadInjoyADExposureManager paramReadInjoyADExposureManager, int paramInt, AdRequestData paramAdRequestData) {}
  
  public void run()
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(this.a, 4, 0, 10000, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager.1
 * JD-Core Version:    0.7.0.1
 */