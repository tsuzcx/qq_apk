package com.tencent.av.app;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GAccountMonitor
{
  public static String a = "AccountReceiver";
  VideoAppInterface b;
  boolean c = false;
  GAccountMonitor.AccountReceiver d;
  
  public GAccountMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    this.d = new GAccountMonitor.AccountReceiver(paramVideoAppInterface);
  }
  
  public void a()
  {
    if (this.c)
    {
      this.b.getApplication().unregisterReceiver(this.d);
      this.c = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "regist QQ Account Receiver, Declare permissions");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(this.b.getApplication().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    if (this.b.getApplication().registerReceiver(this.d, localIntentFilter, "com.tencent.msg.permission.pushnotify", null) != null) {
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAccountMonitor
 * JD-Core Version:    0.7.0.1
 */