package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.x;

final class BuglyBroadcastReceiver$1
  implements Runnable
{
  BuglyBroadcastReceiver$1(BuglyBroadcastReceiver paramBuglyBroadcastReceiver1, BuglyBroadcastReceiver paramBuglyBroadcastReceiver2) {}
  
  public final void run()
  {
    try
    {
      x.a(BuglyBroadcastReceiver.a().getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
      synchronized (this.a)
      {
        BuglyBroadcastReceiver.b(this.b).registerReceiver(BuglyBroadcastReceiver.a(), BuglyBroadcastReceiver.a(this.b));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */