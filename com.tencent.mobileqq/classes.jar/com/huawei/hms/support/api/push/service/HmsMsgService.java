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
import com.huawei.hms.push.c;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;

public class HmsMsgService
  extends Service
{
  public static void c(Context paramContext, Bundle paramBundle)
  {
    if (!t.a(paramContext))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append(" disable display notification.");
      HMSLog.i("HmsMsgService", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.huawei.push.msg.NOTIFY_MSG");
    ((Intent)localObject).putExtra("selfshow_info", c.a(paramBundle, "selfshow_info"));
    ((Intent)localObject).putExtra("selfshow_token", c.a(paramBundle, "selfshow_token"));
    ((Intent)localObject).setPackage(c.c(paramBundle, "push_package"));
    i.a(paramContext, (Intent)localObject);
    HMSLog.i("HmsMsgService", "invokeSelfShow done");
  }
  
  public static void d(Context paramContext, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.huawei.android.push.intent.RECEIVE");
      localIntent.putExtra("msg_data", c.a(paramBundle, "msg_data"));
      localIntent.putExtra("device_token", c.a(paramBundle, "device_token"));
      localIntent.putExtra("msgIdStr", c.c(paramBundle, "msgIdStr"));
      localIntent.setFlags(32);
      localIntent.setPackage(c.c(paramBundle, "push_package"));
      paramBundle = new StringBuilder();
      paramBundle.append(paramContext.getPackageName());
      paramBundle.append(".permission.PROCESS_PUSH_MSG");
      paramContext.sendBroadcast(localIntent, paramBundle.toString());
      HMSLog.i("HmsMsgService", "send broadcast passby done");
      return;
    }
    catch (SecurityException paramContext)
    {
      break label121;
    }
    catch (Exception paramContext)
    {
      label113:
      label121:
      break label113;
    }
    HMSLog.i("HmsMsgService", "send broadcast Exception");
    return;
    HMSLog.i("HmsMsgService", "send broadcast SecurityException");
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