package com.tencent.mobileqq.activity.emogroupstore;

import ahww;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class SDKEmotionSettingManager$7
  implements Runnable
{
  public SDKEmotionSettingManager$7(ahww paramahww) {}
  
  public void run()
  {
    if (ahww.a(this.this$0).isFinishing())
    {
      QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->activity finish");
      return;
    }
    QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->preForward--fetch openid timeout");
    this.this$0.a = true;
    this.this$0.c();
    ahww.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7
 * JD-Core Version:    0.7.0.1
 */