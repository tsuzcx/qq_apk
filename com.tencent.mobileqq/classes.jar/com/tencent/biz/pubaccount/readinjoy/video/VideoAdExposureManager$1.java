package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import nab;
import ogy;
import pys;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(pys parampys, int paramInt1, int paramInt2, nab paramnab) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    ogy.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */