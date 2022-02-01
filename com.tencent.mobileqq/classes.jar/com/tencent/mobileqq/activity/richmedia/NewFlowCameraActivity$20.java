package com.tencent.mobileqq.activity.richmedia;

import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$20
  implements Runnable
{
  NewFlowCameraActivity$20(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (VideoFilterTools.a(this.this$0.getApplicationContext()))
    {
      VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
      localVideoFilterTools.a(this.this$0.getApplicationContext(), new NewFlowCameraActivity.20.1(this, localVideoFilterTools));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.20
 * JD-Core Version:    0.7.0.1
 */