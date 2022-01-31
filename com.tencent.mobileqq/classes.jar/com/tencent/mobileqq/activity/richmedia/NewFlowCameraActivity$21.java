package com.tencent.mobileqq.activity.richmedia;

import ajqu;
import ajsv;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21
  implements Runnable
{
  NewFlowCameraActivity$21(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (ajsv.a(this.this$0.getApplicationContext()))
    {
      ajsv localajsv = ajsv.a();
      localajsv.a(this.this$0.getApplicationContext(), new ajqu(this, localajsv));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21
 * JD-Core Version:    0.7.0.1
 */