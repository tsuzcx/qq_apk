package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import nkz;
import osg;
import qkp;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(qkp paramqkp, int paramInt1, int paramInt2, nkz paramnkz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    osg.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */