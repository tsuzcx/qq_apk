package com.tencent.mobileqq.app.guard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.qphone.base.util.QLog;

class GuardManager$ScreenLockReceiver
  extends BroadcastReceiver
{
  GuardManager$ScreenLockReceiver(GuardManager paramGuardManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (this.this$0.mStartTime > 0L)
      {
        paramContext = this.this$0;
        paramContext.reportForegroundRunningTime(false, paramContext.mFgProcess);
      }
      GuardManagerCallbackDispatcher.a(false);
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      GuardManagerCallbackDispatcher.a(true);
      if ((this.this$0.mStartTime == 0L) && (this.this$0.mFgProcess != null))
      {
        this.this$0.mStartTime = SystemClock.uptimeMillis();
        paramContext = this.this$0;
        paramContext.reportForegroundEvent(paramContext.mFgProcess);
        paramContext = new StringBuilder();
        paramContext.append("848QQDT [onReceive] resetTime: ");
        paramContext.append(this.this$0.mStartTime);
        QLog.d("GuardManager", 1, paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardManager.ScreenLockReceiver
 * JD-Core Version:    0.7.0.1
 */