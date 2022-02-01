package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class q
{
  public static long a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l1 = 0L;
    try
    {
      paramString = new Date();
      int j = paramString.getHours() * 2 + paramString.getMinutes() / 30;
      str = str.concat(str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startIndex is ");
      localStringBuilder.append(j);
      localStringBuilder.append(",ap is:");
      localStringBuilder.append(str);
      localStringBuilder.append(",length is:");
      localStringBuilder.append(str.length());
      HMSLog.i("PushSelfShowLog", localStringBuilder.toString());
      int k = str.length();
      int i = j;
      while (i < k)
      {
        if (str.charAt(i) != '0')
        {
          long l2 = 60000L * ((i - j) * 30 - paramString.getMinutes() % 30);
          paramString = new StringBuilder();
          paramString.append("startIndex is:");
          paramString.append(j);
          paramString.append(" i is:");
          paramString.append(i);
          paramString.append(" delay:");
          paramString.append(l2);
          HMSLog.d("PushSelfShowLog", paramString.toString());
          if (l2 >= 0L) {
            l1 = l2;
          }
          return l1;
        }
        i += 1;
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      HMSLog.e("PushSelfShowLog", "error ", paramString);
    }
  }
  
  public static Boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        int j = paramContext.size();
        int i = 0;
        while (i < j)
        {
          if ((((ResolveInfo)paramContext.get(i)).activityInfo != null) && (paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.applicationInfo.packageName))) {
            return Boolean.valueOf(true);
          }
          i += 1;
        }
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushSelfShowLog", paramContext.toString(), paramContext);
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label25:
      break label25;
    }
    paramContext = new StringBuilder();
    paramContext.append("get the app name of package:");
    paramContext.append(paramString);
    paramContext.append(" failed.");
    HMSLog.i("PushSelfShowLog", paramContext.toString());
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      HMSLog.e("PushSelfShowLog", "context is null");
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null)
      {
        paramContext.cancel(paramInt);
        return;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeNotifiCationById err:");
      localStringBuilder.append(paramContext.toString());
      HMSLog.e("PushSelfShowLog", localStringBuilder.toString());
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      int i = paramIntent.getIntExtra("selfshow_auto_clear_id", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("setDelayAlarm(cancel) alarmNotityId ");
      paramIntent.append(i);
      HMSLog.d("PushSelfShowLog", paramIntent.toString());
      if (i == 0) {
        return;
      }
      Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
      localIntent.setPackage(paramContext.getPackageName()).setFlags(32);
      paramIntent = (AlarmManager)paramContext.getSystemService("alarm");
      paramContext = PendingIntent.getBroadcast(paramContext, i, localIntent, 536870912);
      if ((paramContext != null) && (paramIntent != null))
      {
        HMSLog.d("PushSelfShowLog", "alarm cancel");
        paramIntent.cancel(paramContext);
        return;
      }
      HMSLog.d("PushSelfShowLog", "alarm not exist");
      return;
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("cancelAlarm err:");
      paramIntent.append(paramContext.toString());
      HMSLog.e("PushSelfShowLog", paramIntent.toString());
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enter setAPDelayAlarm(intent:");
      ((StringBuilder)localObject).append(paramIntent.toURI());
      ((StringBuilder)localObject).append(" interval:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("ms, context:");
      ((StringBuilder)localObject).append(paramContext);
      HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
      localObject = (AlarmManager)paramContext.getSystemService("alarm");
      if (localObject != null)
      {
        paramContext = PendingIntent.getBroadcast(paramContext, (int)(System.currentTimeMillis() / 1000L), paramIntent, 0);
        ((AlarmManager)localObject).set(0, System.currentTimeMillis() + paramLong, paramContext);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("set DelayAlarm error");
      paramIntent.append(paramContext.toString());
      HMSLog.w("PushSelfShowLog", paramIntent.toString());
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean a(Context paramContext)
  {
    return "com.huawei.hwid".equals(paramContext.getPackageName());
  }
  
  public static Intent b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getLaunchIntentForPackage(paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label13:
      break label13;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append(" not have launch activity");
    HMSLog.w("PushSelfShowLog", paramContext.toString());
    return null;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      if ("".equals(paramString)) {
        return false;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      if (paramContext == null) {
        return false;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(" is installed");
      HMSLog.d("PushSelfShowLog", paramContext.toString());
      return true;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramContext.getPackageManager().getPreferredActivities(localArrayList1, localArrayList2, paramString);
    return localArrayList2.size() > 0;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      HMSLog.i("PushSelfShowLog", "url is null.");
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.setFlags(402653184);
      Object localObject = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
      String str = null;
      Iterator localIterator = ((List)localObject).iterator();
      boolean bool;
      do
      {
        paramString = str;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = ((ResolveInfo)localIterator.next()).activityInfo.packageName;
        bool = d(paramContext, paramString);
      } while (!bool);
      str = paramString;
      if (paramString == null)
      {
        localObject = ((List)localObject).iterator();
        do
        {
          str = paramString;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = ((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName;
        } while (!"com.android.browser".equalsIgnoreCase(str));
      }
      if (str != null) {
        localIntent.setPackage(str);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("start browser activity failed, exception:");
      paramString.append(paramContext.getMessage());
      HMSLog.e("PushSelfShowLog", paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.q
 * JD-Core Version:    0.7.0.1
 */