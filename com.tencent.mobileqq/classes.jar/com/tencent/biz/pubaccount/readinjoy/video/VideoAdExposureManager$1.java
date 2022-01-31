package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import nlc;
import osj;
import qks;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(qks paramqks, int paramInt1, int paramInt2, nlc paramnlc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    osj.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nlc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */