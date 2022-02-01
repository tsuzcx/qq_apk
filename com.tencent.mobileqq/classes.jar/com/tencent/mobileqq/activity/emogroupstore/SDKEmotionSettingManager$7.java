package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class SDKEmotionSettingManager$7
  implements Runnable
{
  SDKEmotionSettingManager$7(SDKEmotionSettingManager paramSDKEmotionSettingManager) {}
  
  public void run()
  {
    if (SDKEmotionSettingManager.a(this.this$0).isFinishing())
    {
      QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->activity finish");
      return;
    }
    QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->preForward--fetch openid timeout");
    SDKEmotionSettingManager localSDKEmotionSettingManager = this.this$0;
    localSDKEmotionSettingManager.a = true;
    localSDKEmotionSettingManager.d();
    SDKEmotionSettingManager.j(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7
 * JD-Core Version:    0.7.0.1
 */