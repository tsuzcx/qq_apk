package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.ab;
import com.huawei.hms.push.k;
import com.huawei.hms.push.l;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;
import java.util.List;

public class PluginUtil
{
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HMSLog.i("PluginUtil", "onNotification");
    if (!x.a(paramContext))
    {
      HMSLog.i("PluginUtil", paramContext.getPackageName() + " disable display notification.");
      k.a(paramContext, paramString1, "103");
      return;
    }
    paramString1 = new Intent();
    paramString1.setAction("com.huawei.push.msg.NOTIFY_MSG");
    paramString1.putExtra("selfshow_info", paramString3.getBytes(ab.a));
    paramString1.putExtra("selfshow_token", paramString2.getBytes(ab.a));
    paramString1.setPackage(paramContext.getPackageName());
    m.a(paramContext, paramString1);
    HMSLog.i("PluginUtil", "invokeSelfShow done");
  }
  
  private static boolean a(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
        break label84;
      }
      if ((localRunningAppProcessInfo.importance != 100) && (localRunningAppProcessInfo.importance != 200)) {
        bool = true;
      }
    }
    label84:
    for (;;)
    {
      break;
      bool = false;
      continue;
      return bool;
    }
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (TextUtils.equals(paramArrayOfString[1], "0")) {
      if (!a(paramContext))
      {
        bool1 = bool2;
        if (!TextUtils.equals(paramArrayOfString[2], "1")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HMSLog.i("PluginUtil", "onMessageReceived");
    if (TextUtils.isEmpty(paramString3))
    {
      HMSLog.i("PluginUtil", "Empty message received");
      return true;
    }
    k.a(paramContext, paramString1, "102");
    paramString2 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    paramString2.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", paramString1);
    localBundle.putByteArray("message_body", paramString3.getBytes(ab.a));
    localBundle.putString("message_type", "received_message");
    return new l().a(paramContext, localBundle, paramString2);
  }
  
  public static boolean onDeletedMessages(Context paramContext)
  {
    HMSLog.i("PluginUtil", "onDeletedMessages");
    if (paramContext == null) {
      return false;
    }
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putInt("message_proxy_type", ProxyCenter.getInstance().getProxy().getProxyType());
    localBundle.putString("message_type", "server_deleted_message");
    return new l().a(paramContext, localBundle, localIntent);
  }
  
  public static void onMessage(Context paramContext, String[] paramArrayOfString)
  {
    HMSLog.i("PluginUtil", "onMessage");
    if ((paramContext == null) || (paramArrayOfString == null) || (paramArrayOfString.length < 5)) {
      return;
    }
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
    }
    if (a(paramContext, paramArrayOfString))
    {
      a(paramContext, paramArrayOfString[0], paramArrayOfString[3], paramArrayOfString[4]);
      return;
    }
    b(paramContext, paramArrayOfString[0], paramArrayOfString[3], paramArrayOfString[4]);
  }
  
  public static boolean onNewToken(Context paramContext, String paramString)
  {
    HMSLog.i("PluginUtil", "onNewToken");
    if (paramContext == null) {
      return false;
    }
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("message_type", "new_token");
    localBundle.putString("device_token", paramString);
    return new l().a(paramContext, localBundle, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.utils.PluginUtil
 * JD-Core Version:    0.7.0.1
 */