package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import krx;
import kvq;
import lou;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      krx.e("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    kvq localkvq = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localkvq != null)
    {
      QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", mCurrentVideoGlassWaitTime=" + localkvq.P + ", mCurrentDefaultTimeOutRule=" + localkvq.Q + ", mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.a(localkvq.Q);
      return;
    }
    krx.e("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */