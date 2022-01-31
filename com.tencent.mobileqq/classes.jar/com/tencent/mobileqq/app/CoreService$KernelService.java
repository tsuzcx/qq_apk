package com.tencent.mobileqq.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CoreService$KernelService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("k_start_mode", 2);
    BaseApplicationImpl.sApplication.onActivityCreate(this, localIntent);
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "TempService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "TempService.onDestroy");
    }
    try
    {
      super.stopForeground(true);
      label19:
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (CoreService.sCore != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "onStartCommand:");
      }
    }
    try
    {
      CoreService.sCore.startForeground(CoreService.NOTIFICATION_ID, CoreService.fakeNotification(true));
      super.startForeground(CoreService.NOTIFICATION_ID, CoreService.fakeNotification(false));
      CoreService.sCore.stopForeground(true);
      return 2;
    }
    catch (Exception paramIntent)
    {
      QLog.d("GuardManager", 1, "", paramIntent);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService.KernelService
 * JD-Core Version:    0.7.0.1
 */