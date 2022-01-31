package com.tencent.mobileqq.activity.richmedia;

import ahub;
import ahvy;
import ahwb;
import ahwt;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$7
  implements Runnable
{
  NewFlowCameraActivity$7(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = this.this$0.e;
    NewFlowCameraActivity.a(this.this$0);
    ahwt.a(str, ahvy.a);
    this.this$0.q = 0;
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with capture from video");
    }
    NewFlowCameraActivity.a(this.this$0);
    if (this.this$0.a == null) {}
    for (str = "";; str = this.this$0.a.a())
    {
      ahub.a("", "0X80075BE", str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.7
 * JD-Core Version:    0.7.0.1
 */