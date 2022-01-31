package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lek;
import lid;
import mbw;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lek.e("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallid != null)
    {
      QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", mCurrentVideoGlassWaitTime=" + locallid.R + ", mCurrentDefaultTimeOutRule=" + locallid.S + ", mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.a(locallid.S);
      return;
    }
    lek.e("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */