package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import ayor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.util.WeakReference;

public final class BatteryBroadcastReceiver
  extends BroadcastReceiver
{
  private int jdField_a_of_type_Int = -1;
  private final WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  
  public BatteryBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localQQAppInterface != null) && (localQQAppInterface.getOnlineStatus() == AppRuntime.Status.online) && (localQQAppInterface.getExtOnlineStatus() == 1000L))
    {
      localQQAppInterface.a(AppRuntime.Status.online, 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, "toggleChangeInCharging");
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      paramContext = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, new Object[] { "onReceive action:", str });
      }
      if (!TextUtils.equals(str, "android.intent.action.ACTION_POWER_CONNECTED")) {
        break label71;
      }
      if (paramContext != null) {
        paramContext.setPowerConnect(1);
      }
      a();
    }
    label71:
    int i;
    do
    {
      do
      {
        return;
        if (TextUtils.equals(str, "android.intent.action.ACTION_POWER_DISCONNECTED"))
        {
          if (paramContext != null) {
            paramContext.setPowerConnect(0);
          }
          a();
          return;
        }
      } while (!TextUtils.equals(str, "android.intent.action.BATTERY_CHANGED"));
      int j = paramIntent.getIntExtra("level", 0);
      int k = paramIntent.getIntExtra("scale", 100);
      i = j;
      if (k != 0) {
        i = j * 100 / k;
      }
    } while (paramContext == null);
    paramIntent = paramContext.getOnlineStatus();
    long l = paramContext.getExtOnlineStatus();
    if (QLog.isColorLevel()) {
      QLog.d("BatteryBroadcastReceiver", 2, "onBatteryChanged onlineStatus == " + paramIntent + ", extOnlineStatus() == " + l);
    }
    if ((paramIntent == AppRuntime.Status.online) && (l == 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, "onBatteryChanged curLevel == " + i + ", lastLevel == " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        paramIntent = new Bundle();
        paramIntent.putInt("KEY_BATTERY", i);
        paramContext.notifyObservers(ayor.class, 0, true, paramIntent);
      }
    }
    paramContext.setBatteryCapacity(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BatteryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */