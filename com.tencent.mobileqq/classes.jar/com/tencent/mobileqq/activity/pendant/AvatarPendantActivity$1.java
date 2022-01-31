package com.tencent.mobileqq.activity.pendant;

import aipi;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$1
  implements Runnable
{
  AvatarPendantActivity$1(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    try
    {
      aipi.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvatarPendantActivity", 1, "onCreate, showSettingResultDialog exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.1
 * JD-Core Version:    0.7.0.1
 */