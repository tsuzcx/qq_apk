package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.GenerateManifestCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

class NewFlowCameraActivity$53
  implements QQStoryTakeVideoHelper.GenerateManifestCallback
{
  NewFlowCameraActivity$53(NewFlowCameraActivity paramNewFlowCameraActivity, long paramLong, int paramInt) {}
  
  public void a()
  {
    SLog.c("PTV.NewFlowCameraActivity", "generate manifest file success. cost = " + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.post(new NewFlowCameraActivity.53.1(this));
  }
  
  public void b()
  {
    SLog.e("PTV.NewFlowCameraActivity", "generate manifest file failed. cost = " + (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.53
 * JD-Core Version:    0.7.0.1
 */