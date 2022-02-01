package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.e;
import com.huawei.hms.push.h;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginUtil
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject1.put("data", paramString);
      localJSONObject2.put("msgContent", localJSONObject1);
      paramString = localJSONObject2.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      label48:
      break label48;
    }
    HMSLog.e("PluginUtil", "rebuild message failed");
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    e.a(paramContext, paramString, null, "102");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HMSLog.i("PluginUtil", "onNotification");
    if (!t.a(paramContext))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramContext.getPackageName());
      paramString2.append(" disable display notification.");
      HMSLog.i("PluginUtil", paramString2.toString());
      e.a(paramContext, paramString1, null, "103");
      return;
    }
    paramString1 = new Intent();
    paramString1.setAction("com.huawei.push.msg.NOTIFY_MSG");
    paramString1.putExtra("selfshow_info", paramString3.getBytes(w.a));
    paramString1.putExtra("selfshow_token", paramString2.getBytes(w.a));
    paramString1.setPackage(paramContext.getPackageName());
    i.a(paramContext, paramString1);
    HMSLog.i("PluginUtil", "invokeSelfShow done");
  }
  
  public static boolean a(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    boolean bool = true;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return bool;
      }
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))
      {
        int i = localRunningAppProcessInfo.importance;
        if ((i != 100) && (i != 200)) {
          break;
        }
        bool = false;
      }
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    boolean bool = true;
    if (TextUtils.equals(paramArrayOfString[1], "0"))
    {
      if (!a(paramContext))
      {
        if (TextUtils.equals(paramArrayOfString[2], "1")) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public static void onAppOpened(Context paramContext, String paramString1, String paramString2)
  {
    e.a(paramContext, paramString1, paramString2, "appHasOpenedId");
  }
  
  public static boolean onDataMessage(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HMSLog.i("PluginUtil", "onDataMessage");
    if (TextUtils.isEmpty(paramString2))
    {
      HMSLog.i("PluginUtil", "Empty message received");
      return true;
    }
    if (paramBoolean) {
      a(paramContext, paramString1);
    }
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", paramString1);
    localBundle.putByteArray("message_body", paramString2.getBytes(w.a));
    localBundle.putString("message_type", "received_message");
    return new h().a(paramContext, localBundle, localIntent);
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
    localBundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
    localBundle.putString("message_type", "server_deleted_message");
    return new h().a(paramContext, localBundle, localIntent);
  }
  
  public static void onMessage(Context paramContext, String[] paramArrayOfString)
  {
    HMSLog.i("PluginUtil", "onMessage");
    if ((paramContext != null) && (paramArrayOfString != null))
    {
      if (paramArrayOfString.length < 5) {
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
      onDataMessage(paramContext, paramArrayOfString[0], paramArrayOfString[4], true);
    }
  }
  
  public static boolean onNewToken(Context paramContext, String paramString1, String paramString2, ErrorEnum paramErrorEnum)
  {
    HMSLog.i("PluginUtil", "onNewToken called.");
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putInt("error", paramErrorEnum.getInternalCode());
    localBundle.putString("message_type", "new_token");
    localBundle.putString("device_token", paramString1);
    if (TextUtils.equals(paramString2, paramContext.getPackageName())) {
      localBundle.putString("subjectId", null);
    } else {
      localBundle.putString("subjectId", paramString2);
    }
    localBundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
    return new h().a(paramContext, localBundle, localIntent);
  }
  
  public static void onNotificationArrived(Context paramContext, String paramString1, String paramString2)
  {
    e.a(paramContext, paramString1, paramString2, "100");
  }
  
  public static void onNotificationClicked(Context paramContext, String paramString1, String paramString2)
  {
    e.a(paramContext, paramString1, paramString2, "1");
    onAppOpened(paramContext, paramString1, paramString2);
  }
  
  public static boolean onOldDataMessage(Context paramContext, String paramString1, String paramString2)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
    }
    return onDataMessage(paramContext, paramString1, a(paramString2), true);
  }
  
  public static void saveNotifySwitch(Context paramContext, boolean paramBoolean)
  {
    new PushPreferences(paramContext, "push_notify_flag").saveBoolean("notify_msg_enable", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.utils.PluginUtil
 * JD-Core Version:    0.7.0.1
 */