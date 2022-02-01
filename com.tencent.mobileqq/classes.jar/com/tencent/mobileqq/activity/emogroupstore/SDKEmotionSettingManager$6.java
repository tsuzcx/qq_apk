package com.tencent.mobileqq.activity.emogroupstore;

import ajyt;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKEmotionSettingManager$6
  implements Runnable
{
  public SDKEmotionSettingManager$6(ajyt paramajyt) {}
  
  public void run()
  {
    if (ajyt.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    this.this$0.b = true;
    ajyt.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6
 * JD-Core Version:    0.7.0.1
 */