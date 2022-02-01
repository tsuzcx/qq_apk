package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class SDKEmotionSettingManager$6
  implements Runnable
{
  SDKEmotionSettingManager$6(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void run()
  {
    if (SDKEmotionSettingManager.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    SDKEmotionSettingManager localSDKEmotionSettingManager = this.this$0;
    localSDKEmotionSettingManager.b = true;
    SDKEmotionSettingManager.g(localSDKEmotionSettingManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6
 * JD-Core Version:    0.7.0.1
 */