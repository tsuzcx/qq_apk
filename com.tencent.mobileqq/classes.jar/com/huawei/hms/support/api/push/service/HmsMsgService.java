package com.huawei.hms.support.api.push.service;

import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import com.huawei.hms.push.f;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;

public class HmsMsgService
  extends Service
{
  private static void c(Context paramContext, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.huawei.android.push.intent.RECEIVE");
      localIntent.putExtra("msg_data", f.c(paramBundle, "msg_data"));
      localIntent.putExtra("device_token", f.c(paramBundle, "device_token"));
      localIntent.putExtra("msgIdStr", f.b(paramBundle, "msgIdStr"));
      localIntent.setFlags(32);
      localIntent.setPackage(f.b(paramBundle, "push_package"));
      paramContext.sendBroadcast(localIntent, paramContext.getPackageName() + ".permission.PROCESS_PUSH_MSG");
      HMSLog.i("HmsMsgService", "send broadcast passby done");
      return;
    }
    catch (SecurityException paramContext)
    {
      HMSLog.i("HmsMsgService", "send broadcast SecurityException");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.i("HmsMsgService", "send broadcast Exception");
    }
  }
  
  private static void d(Context paramContext, Bundle paramBundle)
  {
    if (!x.a(paramContext)) {
      HMSLog.i("HmsMsgService", paramContext.getPackageName() + " disable display notification.");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.push.msg.NOTIFY_MSG");
    localIntent.putExtra("selfshow_info", f.c(paramBundle, "selfshow_info"));
    localIntent.putExtra("selfshow_token", f.c(paramBundle, "selfshow_token"));
    localIntent.setPackage(f.b(paramBundle, "push_package"));
    m.a(paramContext, localIntent);
    HMSLog.i("HmsMsgService", "invokeSelfShow done");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    HMSLog.i("HmsMsgService", "onBind");
    Messenger localMessenger = new Messenger(new HmsMsgService.a(this));
    stopService(paramIntent);
    return localMessenger.getBinder();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 26) {
      stopForeground(true);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    HMSLog.i("HmsMsgService", "Enter onStartCommand.");
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramIntent = new NotificationChannel("HwPushChannelID", "pushKit", 3);
      paramIntent.enableVibration(false);
      NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
      if (localNotificationManager != null) {
        localNotificationManager.createNotificationChannel(paramIntent);
      }
      paramIntent = new Notification.Builder(this, "HwPushChannelID");
      paramIntent.setAutoCancel(true);
      startForeground(1, paramIntent.build());
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.service.HmsMsgService
 * JD-Core Version:    0.7.0.1
 */