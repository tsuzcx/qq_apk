package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$2
  implements Runnable
{
  AvatarPendantActivity$2(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    try
    {
      SdkDynamicAvatarSettingHelper.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvatarPendantActivity", 1, "onCreate, showSettingResultDialog exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.2
 * JD-Core Version:    0.7.0.1
 */