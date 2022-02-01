package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.util.WeakReference;

public final class BatteryBroadcastReceiver
  extends BroadcastReceiver
{
  private int jdField_a_of_type_Int = -1;
  private final WeakReference<AppRuntime> jdField_a_of_type_MqqUtilWeakReference;
  
  public BatteryBroadcastReceiver(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
  }
  
  private void a()
  {
    Object localObject = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject != null)
    {
      localObject = (IOnlineStatusService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusService.class, "");
      if ((((IOnlineStatusService)localObject).getOnlineStatus() == AppRuntime.Status.online) && (((IOnlineStatusService)localObject).getExtOnlineStatus() == 1000L))
      {
        ((IOnlineStatusService)localObject).updateOnlineStatus(AppRuntime.Status.online, 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("BatteryBroadcastReceiver", 2, "toggleChangeInCharging");
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getAction();
      paramContext = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("BatteryBroadcastReceiver", 2, new Object[] { "onReceive action:", localObject });
      }
      if (TextUtils.equals((CharSequence)localObject, "android.intent.action.ACTION_POWER_CONNECTED"))
      {
        if (paramContext != null) {
          ((IOnlineStatusService)paramContext.getRuntimeService(IOnlineStatusService.class, "")).setPowerConnect(1);
        }
        a();
        return;
      }
      if (TextUtils.equals((CharSequence)localObject, "android.intent.action.ACTION_POWER_DISCONNECTED"))
      {
        if (paramContext != null) {
          ((IOnlineStatusService)paramContext.getRuntimeService(IOnlineStatusService.class, "")).setPowerConnect(0);
        }
        a();
        return;
      }
      if (TextUtils.equals((CharSequence)localObject, "android.intent.action.BATTERY_CHANGED"))
      {
        int j = paramIntent.getIntExtra("level", 0);
        int k = paramIntent.getIntExtra("scale", 100);
        int i = j;
        if (k != 0) {
          i = j * 100 / k;
        }
        if (paramContext != null)
        {
          localObject = (IOnlineStatusService)paramContext.getRuntimeService(IOnlineStatusService.class, "");
          paramIntent = ((IOnlineStatusService)localObject).getOnlineStatus();
          long l = ((IOnlineStatusService)localObject).getExtOnlineStatus();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onBatteryChanged onlineStatus == ");
            ((StringBuilder)localObject).append(paramIntent);
            ((StringBuilder)localObject).append(", extOnlineStatus() == ");
            ((StringBuilder)localObject).append(l);
            QLog.d("BatteryBroadcastReceiver", 2, ((StringBuilder)localObject).toString());
          }
          if ((paramIntent == AppRuntime.Status.online) && (l == 1000L))
          {
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onBatteryChanged curLevel == ");
              paramIntent.append(i);
              paramIntent.append(", lastLevel == ");
              paramIntent.append(this.jdField_a_of_type_Int);
              QLog.d("BatteryBroadcastReceiver", 2, paramIntent.toString());
            }
            if (this.jdField_a_of_type_Int != i)
            {
              this.jdField_a_of_type_Int = i;
              paramIntent = new Bundle();
              paramIntent.putInt("KEY_BATTERY", i);
              paramContext.notifyObservers(OnBatteryChangeObserver.class, 26364, true, paramIntent);
            }
          }
          ((IOnlineStatusService)paramContext.getRuntimeService(IOnlineStatusService.class, "")).setBatteryCapacity(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BatteryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */