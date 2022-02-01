package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;

class VideoAdExposureManager$1
  implements Runnable
{
  VideoAdExposureManager$1(VideoAdExposureManager paramVideoAdExposureManager, int paramInt1, int paramInt2, AdRequestData paramAdRequestData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    ReadInJoyLogicEngine.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataAdRequestData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */