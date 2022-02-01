package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class SDKAvatarSettingManager$4
  implements Runnable
{
  SDKAvatarSettingManager$4(SDKAvatarSettingManager paramSDKAvatarSettingManager) {}
  
  public void run()
  {
    if (SDKAvatarSettingManager.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    SDKAvatarSettingManager localSDKAvatarSettingManager = this.this$0;
    localSDKAvatarSettingManager.b = true;
    SDKAvatarSettingManager.d(localSDKAvatarSettingManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.4
 * JD-Core Version:    0.7.0.1
 */