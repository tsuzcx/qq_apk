package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class SDKAvatarSettingManager$5
  implements Runnable
{
  SDKAvatarSettingManager$5(SDKAvatarSettingManager paramSDKAvatarSettingManager) {}
  
  public void run()
  {
    if (SDKAvatarSettingManager.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKAvatarSettingManager", 2, "-->preForward--fetch openid timeout");
    }
    SDKAvatarSettingManager localSDKAvatarSettingManager = this.this$0;
    localSDKAvatarSettingManager.a = true;
    localSDKAvatarSettingManager.d();
    localSDKAvatarSettingManager = this.this$0;
    SDKAvatarSettingManager.a(localSDKAvatarSettingManager, SDKAvatarSettingManager.a(localSDKAvatarSettingManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager.5
 * JD-Core Version:    0.7.0.1
 */