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
      if (this.a.jdField_a_of_type_Long > 0L)
      {
        paramContext = this.a;
        paramContext.a(false, paramContext.jdField_a_of_type_JavaLangString);
      }
      GuardManagerCallbackDispatcher.a(false);
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      GuardManagerCallbackDispatcher.a(true);
      if ((this.a.jdField_a_of_type_Long == 0L) && (this.a.jdField_a_of_type_JavaLangString != null))
      {
        this.a.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        paramContext = this.a;
        paramContext.b(paramContext.jdField_a_of_type_JavaLangString);
        paramContext = new StringBuilder();
        paramContext.append("848QQDT [onReceive] resetTime: ");
        paramContext.append(this.a.jdField_a_of_type_Long);
        QLog.d("GuardManager", 1, paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardManager.ScreenLockReceiver
 * JD-Core Version:    0.7.0.1
 */