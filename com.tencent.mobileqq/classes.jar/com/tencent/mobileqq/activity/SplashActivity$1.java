package com.tencent.mobileqq.activity;

import afox;
import android.content.IntentFilter;
import bcvn;
import blhw;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class SplashActivity$1
  implements Runnable
{
  SplashActivity$1(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("SplashActivity", 241);
      bcvn localbcvn = (bcvn)this.this$0.app.getManager(10);
      if (localbcvn != null) {
        localbcvn.a(1, 0);
      }
      localQQNotificationManager.cancel("SplashActivity", 265);
      localQQNotificationManager.cancel("SplashActivity", 267);
      localQQNotificationManager.cancel("SplashActivity", 274);
      localQQNotificationManager.cancel("SplashActivity", 236);
      localQQNotificationManager.cancel("SplashActivity", 271);
      localQQNotificationManager.cancel("SplashActivity", 273);
      localQQNotificationManager.cancel("SplashActivity", 269);
      localQQNotificationManager.cancel("SplashActivity", 239);
      localQQNotificationManager.cancel("SplashActivity", 527);
      blhw.a(this.this$0.app).a();
      SplashActivity.a(this.this$0, new afox(this));
      this.this$0.registerReceiver(SplashActivity.a(this.this$0), new IntentFilter("before_account_change"));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.1
 * JD-Core Version:    0.7.0.1
 */