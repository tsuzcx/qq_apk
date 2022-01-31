package com.tencent.mobileqq.activity.emogroupstore;

import afup;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKEmotionSettingManager$5
  implements Runnable
{
  public SDKEmotionSettingManager$5(afup paramafup) {}
  
  public void run()
  {
    if (afup.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
    }
    this.this$0.b = true;
    afup.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.5
 * JD-Core Version:    0.7.0.1
 */