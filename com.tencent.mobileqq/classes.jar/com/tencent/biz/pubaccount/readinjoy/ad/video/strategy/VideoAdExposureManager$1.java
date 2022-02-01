package com.tencent.biz.pubaccount.readinjoy.ad.video.strategy;

import com.tencent.qphone.base.util.QLog;
import nwv;
import orj;
import pmh;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(orj paramorj, int paramInt1, int paramInt2, nwv paramnwv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    pmh.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nwv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.video.strategy.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */