package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher;
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
      if (this.a.jdField_a_of_type_Long > 0L) {
        this.a.a(false, this.a.jdField_a_of_type_JavaLangString);
      }
      GuardManagerCallbackDispatcher.a(false);
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      GuardManagerCallbackDispatcher.a(true);
    } while ((this.a.jdField_a_of_type_Long != 0L) || (this.a.jdField_a_of_type_JavaLangString == null));
    this.a.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.a.b(this.a.jdField_a_of_type_JavaLangString);
    QLog.d("GuardManager", 1, "848QQDT [onReceive] resetTime: " + this.a.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardManager.ScreenLockReceiver
 * JD-Core Version:    0.7.0.1
 */