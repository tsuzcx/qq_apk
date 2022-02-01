package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.qphone.base.util.QLog;
import nyp;
import pfa;
import trb;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(trb paramtrb, int paramInt1, int paramInt2, nyp paramnyp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    pfa.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */