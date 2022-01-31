package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import nnv;
import owy;
import qzw;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(qzw paramqzw, int paramInt1, int paramInt2, nnv paramnnv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.jdField_a_of_type_Int);
    }
    owy.a().a(this.b, this.jdField_a_of_type_Int, 0, 10000, this.jdField_a_of_type_Nnv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */