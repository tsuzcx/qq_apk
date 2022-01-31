package com.tencent.mobileqq.activity.richmedia;

import ahuv;
import ahww;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21
  implements Runnable
{
  NewFlowCameraActivity$21(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (ahww.a(this.this$0.getApplicationContext()))
    {
      ahww localahww = ahww.a();
      localahww.a(this.this$0.getApplicationContext(), new ahuv(this, localahww));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21
 * JD-Core Version:    0.7.0.1
 */