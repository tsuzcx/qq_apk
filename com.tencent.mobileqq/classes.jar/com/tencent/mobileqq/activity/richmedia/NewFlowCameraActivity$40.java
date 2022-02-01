package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$40
  implements Runnable
{
  NewFlowCameraActivity$40(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (!this.this$0.m)
    {
      this.this$0.a.a(2002, HardCodeUtil.a(2131707475), false);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.40
 * JD-Core Version:    0.7.0.1
 */