package com.tencent.mobileqq.activity.richmedia;

import alud;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

class FlowCameraActivity2$22
  implements Runnable
{
  FlowCameraActivity2$22(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    if (!this.this$0.b)
    {
      this.this$0.a.a(2002, alud.a(2131705041), false);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.22
 * JD-Core Version:    0.7.0.1
 */