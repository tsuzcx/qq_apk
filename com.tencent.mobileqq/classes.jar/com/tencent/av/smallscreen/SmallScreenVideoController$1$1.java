package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lbj;
import lff;
import lzu;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lbj.e("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    lff locallff = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallff != null)
    {
      QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", mCurrentVideoGlassWaitTime=" + locallff.S + ", mCurrentDefaultTimeOutRule=" + locallff.T + ", mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.a(locallff.T);
      return;
    }
    lbj.e("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */