package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Date;

public class s
{
  private static int a = 0;
  
  private static Notification a(Context paramContext, o paramo, int paramInt1, int paramInt2, int paramInt3)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    if (q.a(paramo) == r.b) {
      q.a(localBuilder, paramo.r(), paramo);
    }
    p.a(paramContext, localBuilder, paramo);
    a(paramo, localBuilder);
    a(paramContext, paramo, localBuilder);
    b(paramContext, paramo, localBuilder);
    a(localBuilder);
    b(paramo, localBuilder);
    c(paramo, localBuilder);
    localBuilder.setContentIntent(a(paramContext, paramo, paramInt1, paramInt2));
    localBuilder.setDeleteIntent(b(paramContext, paramo, paramInt1, paramInt3));
    if (Build.VERSION.SDK_INT >= 26) {
      localBuilder.setChannelId("HwPushChannelID");
    }
    a(paramContext, localBuilder, paramo);
    b(paramContext, localBuilder, paramo);
    return localBuilder.build();
  }
  
  private static PendingIntent a(Context paramContext, o paramo, int paramInt1, int paramInt2)
  {
    return PendingIntent.getBroadcast(paramContext, paramInt2, a(paramContext, paramo, paramInt1, "1", 268435456), 134217728);
  }
  
  private static Intent a(Context paramContext, o paramo, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", paramo.c()).putExtra("selfshow_token", paramo.d()).putExtra("selfshow_event_id", paramString).putExtra("selfshow_notify_id", paramInt1).setPackage(paramContext.getPackageName()).setFlags(paramInt2);
    return localIntent;
  }
  
  private static void a(Notification.Builder paramBuilder)
  {
    paramBuilder.setShowWhen(true);
    paramBuilder.setWhen(System.currentTimeMillis());
  }
  
  @SuppressLint({"NewApi"})
  private static void a(Context paramContext, Notification.Builder paramBuilder, o paramo)
  {
    if ("com.huawei.android.pushagent".equals(paramContext.getPackageName()))
    {
      paramContext = new Bundle();
      paramo = paramo.i();
      if (!TextUtils.isEmpty(paramo))
      {
        paramContext.putString("hw_origin_sender_package_name", paramo);
        paramBuilder.setExtras(paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt)
  {
    try
    {
      HMSLog.d("PushSelfShowLog", "enter setDelayAlarm(intent:" + paramIntent.toURI() + " interval:" + paramLong + "ms, context:" + paramContext);
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (localAlarmManager != null)
      {
        paramContext = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728);
        localAlarmManager.set(0, System.currentTimeMillis() + paramLong, paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, o paramo)
  {
    if ((paramContext == null) || (paramo == null)) {
      return;
    }
    for (;;)
    {
      int m;
      int j;
      try
      {
        HMSLog.d("PushSelfShowLog", " showNotification , the msg id = " + paramo.a());
        if (a == 0) {
          a = (paramContext.getPackageName() + new Date().toString()).hashCode();
        }
        if (!TextUtils.isEmpty(paramo.e())) {
          break label406;
        }
        localObject = paramo.t();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          i = ((String)localObject).hashCode();
          paramo.a(i);
          HMSLog.d("PushSelfShowLog", "notification msgTag = " + i);
        }
        if (paramo.u() == -1) {
          break label359;
        }
        m = paramo.u();
        k = a + 1;
        a = k;
        j = a + 1;
        a = j;
        i = a + 1;
        a = i;
      }
      finally {}
      HMSLog.d("PushSelfShowLog", "notifyId:" + i + ",openNotifyId:" + n + ",delNotifyId:" + j + ",alarmNotifyId:" + k);
      if (u.a())
      {
        localObject = a(paramContext, paramo, i, n, j);
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        if ((localNotificationManager == null) || (localObject == null)) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 26) {
          localNotificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", paramContext.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
        }
        localNotificationManager.notify(i, (Notification)localObject);
        c(paramContext, paramo, i, k);
        k.a(paramContext, "100", String.valueOf(i), paramo);
        break;
        label359:
        m = a + 1;
        a = m;
        k = a + 1;
        a = k;
        j = a + 1;
        a = j;
        i = a + 1;
        a = i;
        break label481;
        label406:
        i = (paramo.i() + paramo.e()).hashCode();
        m = a + 1;
        a = m;
        j = a + 1;
        a = j;
        k = a + 1;
        a = k;
        n = m;
        continue;
      }
      Object localObject = null;
      continue;
      label481:
      int n = k;
      int k = i;
      int i = m;
    }
  }
  
  private static void a(Context paramContext, o paramo, Notification.Builder paramBuilder)
  {
    int i;
    if (TextUtils.isEmpty(paramo.l())) {
      i = paramContext.getApplicationInfo().labelRes;
    }
    for (paramContext = paramContext.getResources().getString(i);; paramContext = paramo.l())
    {
      paramo = paramo.k();
      paramBuilder.setContentTitle(paramContext);
      paramBuilder.setContentText(paramo);
      return;
    }
  }
  
  private static void a(o paramo, Notification.Builder paramBuilder)
  {
    paramo = paramo.p();
    if (!TextUtils.isEmpty(paramo)) {
      paramBuilder.setSubText(paramo);
    }
  }
  
  private static PendingIntent b(Context paramContext, o paramo, int paramInt1, int paramInt2)
  {
    return PendingIntent.getBroadcast(paramContext, paramInt2, a(paramContext, paramo, paramInt1, "2", 268435456), 134217728);
  }
  
  @SuppressLint({"NewApi"})
  private static void b(Context paramContext, Notification.Builder paramBuilder, o paramo)
  {
    if ((HwBuildEx.VERSION.EMUI_SDK_INT >= 11) && (u.a(paramContext)))
    {
      Bundle localBundle = new Bundle();
      paramo = paramo.i();
      HMSLog.i("PushSelfShowLog", "the package name of notification is:" + paramo);
      if (!TextUtils.isEmpty(paramo))
      {
        paramContext = u.a(paramContext, paramo);
        HMSLog.i("PushSelfShowLog", "the app name is:" + paramContext);
        if (paramContext != null) {
          localBundle.putCharSequence("android.extraAppName", paramContext);
        }
      }
      paramBuilder.setExtras(localBundle);
    }
  }
  
  private static void b(Context paramContext, o paramo, Notification.Builder paramBuilder)
  {
    paramContext = p.a(paramContext, paramo);
    if (paramContext != null) {
      paramBuilder.setLargeIcon(paramContext);
    }
  }
  
  private static void b(o paramo, Notification.Builder paramBuilder)
  {
    boolean bool = true;
    if (paramo.s() == 1) {}
    for (;;)
    {
      paramBuilder.setAutoCancel(bool);
      paramBuilder.setOngoing(false);
      return;
      bool = false;
    }
  }
  
  private static void c(Context paramContext, o paramo, int paramInt1, int paramInt2)
  {
    HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + paramo.f());
    if (paramo.f() <= 0) {
      return;
    }
    a(paramContext, a(paramContext, paramo, paramInt1, "-1", 32), paramo.f(), paramInt2);
  }
  
  private static void c(o paramo, Notification.Builder paramBuilder)
  {
    paramBuilder.setTicker(paramo.v());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.s
 * JD-Core Version:    0.7.0.1
 */