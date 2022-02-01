package com.tencent.mobileqq.activity.richmedia;

import alvc;
import alxd;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21
  implements Runnable
{
  NewFlowCameraActivity$21(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (alxd.a(this.this$0.getApplicationContext()))
    {
      alxd localalxd = alxd.a();
      localalxd.a(this.this$0.getApplicationContext(), new alvc(this, localalxd));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21
 * JD-Core Version:    0.7.0.1
 */