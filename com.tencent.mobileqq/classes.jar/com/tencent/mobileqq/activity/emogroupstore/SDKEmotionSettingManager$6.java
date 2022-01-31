package com.tencent.mobileqq.activity.emogroupstore;

import afur;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKEmotionSettingManager$6
  implements Runnable
{
  public SDKEmotionSettingManager$6(afur paramafur) {}
  
  public void run()
  {
    if (afur.a(this.this$0).isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, "checkJumpActionTimeOutRunnable -->preForward--fetch openid timeout");
    }
    this.this$0.a = true;
    this.this$0.c();
    afur.a(this.this$0, afur.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6
 * JD-Core Version:    0.7.0.1
 */