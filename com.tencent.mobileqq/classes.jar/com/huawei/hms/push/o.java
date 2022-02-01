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

public class o
{
  public static int a;
  
  public static Notification a(Context paramContext, k paramk, int[] paramArrayOfInt)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    if (m.a(paramk) == n.b) {
      m.a(localBuilder, paramk.g(), paramk);
    }
    l.a(paramContext, localBuilder, paramk);
    b(paramk, localBuilder);
    b(paramContext, paramk, localBuilder);
    a(paramContext, paramk, localBuilder);
    a(localBuilder);
    a(paramk, localBuilder);
    c(paramk, localBuilder);
    localBuilder.setContentIntent(c(paramContext, paramk, paramArrayOfInt));
    localBuilder.setDeleteIntent(b(paramContext, paramk, paramArrayOfInt));
    if (Build.VERSION.SDK_INT >= 26) {
      localBuilder.setChannelId("HwPushChannelID");
    }
    b(paramContext, localBuilder, paramk);
    a(paramContext, localBuilder, paramk);
    return localBuilder.build();
  }
  
  public static Intent a(Context paramContext, k paramk, int[] paramArrayOfInt, String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", paramk.o()).putExtra("selfshow_token", paramk.y()).putExtra("selfshow_event_id", paramString).putExtra("selfshow_notify_id", paramArrayOfInt[0]).putExtra("selfshow_auto_clear_id", paramArrayOfInt[3]).setPackage(paramContext.getPackageName()).setFlags(paramInt);
    return localIntent;
  }
  
  public static void a(Notification.Builder paramBuilder)
  {
    paramBuilder.setShowWhen(true);
    paramBuilder.setWhen(System.currentTimeMillis());
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, Notification.Builder paramBuilder, k paramk)
  {
    if ((HwBuildEx.VERSION.EMUI_SDK_INT >= 11) && (q.a(paramContext)))
    {
      Bundle localBundle = new Bundle();
      paramk = paramk.k();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the package name of notification is:");
      localStringBuilder.append(paramk);
      HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramk))
      {
        paramContext = q.a(paramContext, paramk);
        paramk = new StringBuilder();
        paramk.append("the app name is:");
        paramk.append(paramContext);
        HMSLog.i("PushSelfShowLog", paramk.toString());
        if (paramContext != null) {
          localBundle.putCharSequence("android.extraAppName", paramContext);
        }
      }
      paramBuilder.setExtras(localBundle);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enter setDelayAlarm(intent:");
      ((StringBuilder)localObject).append(paramIntent.toURI());
      ((StringBuilder)localObject).append(" interval:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("ms, context:");
      ((StringBuilder)localObject).append(paramContext);
      HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
      localObject = (AlarmManager)paramContext.getSystemService("alarm");
      if (localObject != null)
      {
        paramContext = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728);
        ((AlarmManager)localObject).set(0, System.currentTimeMillis() + paramLong, paramContext);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("set DelayAlarm error.");
      paramIntent.append(paramContext.toString());
      HMSLog.w("PushSelfShowLog", paramIntent.toString());
    }
  }
  
  public static void a(Context paramContext, k paramk)
  {
    if ((paramContext != null) && (paramk != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showNotification, the msg id = ");
        ((StringBuilder)localObject).append(paramk.p());
        HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
        if (a == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getPackageName());
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          a = ((StringBuilder)localObject).toString().hashCode();
        }
        int j;
        int k;
        int m;
        if (TextUtils.isEmpty(paramk.l()))
        {
          localObject = paramk.q();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i = ((String)localObject).hashCode();
            paramk.a(i);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("notification msgTag = ");
            ((StringBuilder)localObject).append(i);
            HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
          }
          if (paramk.s() != -1)
          {
            j = paramk.s();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramk.k());
            ((StringBuilder)localObject).append(System.currentTimeMillis());
            k = ((StringBuilder)localObject).toString().hashCode();
            m = k + 1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramk.s());
            ((StringBuilder)localObject).append(paramk.k());
            ((StringBuilder)localObject).append(paramContext.getPackageName());
            i = ((StringBuilder)localObject).toString().hashCode();
          }
          else
          {
            j = a + 1;
            a = j;
            k = a + 1;
            a = k;
            m = a + 1;
            a = m;
            i = a + 1;
            a = i;
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramk.l());
          ((StringBuilder)localObject).append(paramk.k());
          j = ((StringBuilder)localObject).toString().hashCode();
          k = a + 1;
          a = k;
          m = a + 1;
          a = m;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramk.l());
          ((StringBuilder)localObject).append(paramk.k());
          ((StringBuilder)localObject).append(paramContext.getPackageName());
          i = ((StringBuilder)localObject).toString().hashCode();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyId:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",openNotifyId:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(",delNotifyId:");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(",alarmNotifyId:");
        ((StringBuilder)localObject).append(i);
        HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
        int[] arrayOfInt = new int[4];
        arrayOfInt[0] = j;
        arrayOfInt[1] = k;
        arrayOfInt[2] = m;
        if (paramk.f() <= 0) {
          break label671;
        }
        arrayOfInt[3] = i;
        localObject = null;
        if (q.a()) {
          localObject = a(paramContext, paramk, arrayOfInt);
        }
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        if ((localNotificationManager != null) && (localObject != null))
        {
          if (Build.VERSION.SDK_INT >= 26) {
            localNotificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", paramContext.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
          }
          localNotificationManager.notify(j, (Notification)localObject);
          d(paramContext, paramk, arrayOfInt);
          e.a(paramContext, paramk.p(), paramk.b(), "100");
        }
        return;
      }
      finally {}
      return;
      label671:
      int i = 0;
    }
  }
  
  public static void a(Context paramContext, k paramk, Notification.Builder paramBuilder)
  {
    paramContext = l.a(paramContext, paramk);
    if (paramContext != null) {
      paramBuilder.setLargeIcon(paramContext);
    }
  }
  
  public static void a(k paramk, Notification.Builder paramBuilder)
  {
    int i = paramk.e();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramBuilder.setAutoCancel(bool);
    paramBuilder.setOngoing(false);
  }
  
  public static PendingIntent b(Context paramContext, k paramk, int[] paramArrayOfInt)
  {
    paramk = a(paramContext, paramk, paramArrayOfInt, "2", 268435456);
    return PendingIntent.getBroadcast(paramContext, paramArrayOfInt[2], paramk, 134217728);
  }
  
  @SuppressLint({"NewApi"})
  public static void b(Context paramContext, Notification.Builder paramBuilder, k paramk)
  {
    if ("com.huawei.android.pushagent".equals(paramContext.getPackageName()))
    {
      paramContext = new Bundle();
      paramk = paramk.k();
      if (!TextUtils.isEmpty(paramk))
      {
        paramContext.putString("hw_origin_sender_package_name", paramk);
        paramBuilder.setExtras(paramContext);
      }
    }
  }
  
  public static void b(Context paramContext, k paramk, Notification.Builder paramBuilder)
  {
    if (TextUtils.isEmpty(paramk.u()))
    {
      int i = paramContext.getApplicationInfo().labelRes;
      paramContext = paramContext.getResources().getString(i);
    }
    else
    {
      paramContext = paramk.u();
    }
    paramk = paramk.j();
    paramBuilder.setContentTitle(paramContext);
    paramBuilder.setContentText(paramk);
  }
  
  public static void b(k paramk, Notification.Builder paramBuilder)
  {
    paramk = paramk.t();
    if (!TextUtils.isEmpty(paramk)) {
      paramBuilder.setSubText(paramk);
    }
  }
  
  public static PendingIntent c(Context paramContext, k paramk, int[] paramArrayOfInt)
  {
    paramk = a(paramContext, paramk, paramArrayOfInt, "1", 268435456);
    return PendingIntent.getBroadcast(paramContext, paramArrayOfInt[1], paramk, 134217728);
  }
  
  public static void c(k paramk, Notification.Builder paramBuilder)
  {
    paramBuilder.setTicker(paramk.x());
  }
  
  public static void d(Context paramContext, k paramk, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAutoClear time is: ");
    localStringBuilder.append(paramk.f());
    HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
    if (paramk.f() <= 0) {
      return;
    }
    a(paramContext, a(paramContext, paramk, paramArrayOfInt, "-1", 32), paramk.f(), paramArrayOfInt[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.o
 * JD-Core Version:    0.7.0.1
 */