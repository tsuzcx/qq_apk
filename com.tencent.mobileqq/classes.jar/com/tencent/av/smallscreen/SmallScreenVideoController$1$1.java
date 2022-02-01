package com.tencent.av.smallscreen;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$1$1
  implements Runnable
{
  SmallScreenVideoController$1$1(SmallScreenVideoController.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.printErrorLog("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncReadDoubleGlassConfig Timer lCurrent=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(", lLastTick=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", mCurrentVideoGlassWaitTime=");
      localStringBuilder.append(((SessionInfo)localObject).Q);
      localStringBuilder.append(", mCurrentDefaultTimeOutRule=");
      localStringBuilder.append(((SessionInfo)localObject).R);
      localStringBuilder.append(", mCurrentVideoGlassSwitch=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
      QLog.d("SmallScreenVideoController", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.a(((SessionInfo)localObject).R);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AsyncReadDoubleGlassConfig Timer lCurrent=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(", lLastTick=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", sessionInfo is null, mCurrentVideoGlassSwitch=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$1.this$0.jdField_a_of_type_Int);
    AVLog.printErrorLog("SmallScreenVideoController", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1.1
 * JD-Core Version:    0.7.0.1
 */