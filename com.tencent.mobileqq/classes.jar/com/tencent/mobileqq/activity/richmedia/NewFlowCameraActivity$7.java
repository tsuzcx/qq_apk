package com.tencent.mobileqq.activity.richmedia;

import alpt;
import alrq;
import alrt;
import alsj;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$7
  implements Runnable
{
  NewFlowCameraActivity$7(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = this.this$0.e;
    NewFlowCameraActivity.a(this.this$0);
    alsj.a(str, alrq.a);
    this.this$0.q = 0;
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with capture from video");
    }
    NewFlowCameraActivity.a(this.this$0);
    if (this.this$0.a == null) {}
    for (str = "";; str = this.this$0.a.a())
    {
      alpt.a("", "0X80075BE", str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.7
 * JD-Core Version:    0.7.0.1
 */