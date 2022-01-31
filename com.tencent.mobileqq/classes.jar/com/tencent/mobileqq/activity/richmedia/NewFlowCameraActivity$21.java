package com.tencent.mobileqq.activity.richmedia;

import ahux;
import ahwy;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21
  implements Runnable
{
  NewFlowCameraActivity$21(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (ahwy.a(this.this$0.getApplicationContext()))
    {
      ahwy localahwy = ahwy.a();
      localahwy.a(this.this$0.getApplicationContext(), new ahux(this, localahwy));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21
 * JD-Core Version:    0.7.0.1
 */