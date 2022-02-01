package com.huawei.hms.aaid.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseUtils
{
  public static void clearSubjectIds(Context paramContext)
  {
    i.a(paramContext).removeKey("subjectId");
  }
  
  public static void delLocalToken(Context paramContext, String paramString)
  {
    i.a(paramContext).c(paramString);
  }
  
  public static void deleteAllTokenCache(Context paramContext)
  {
    i.a(paramContext).a();
  }
  
  public static void deleteCacheData(Context paramContext, String paramString)
  {
    i.a(paramContext).removeKey(paramString);
  }
  
  public static String getBaseUrl(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return e.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static String getCacheData(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return i.a(paramContext).a(paramString);
    }
    return i.a(paramContext).getString(paramString);
  }
  
  public static String getLocalToken(Context paramContext, String paramString)
  {
    return i.a(paramContext).b(paramString);
  }
  
  public static boolean getProxyInit(Context paramContext)
  {
    return i.a(paramContext).getBoolean("_proxy_init");
  }
  
  public static String[] getSubjectIds(Context paramContext)
  {
    paramContext = i.a(paramContext).getString("subjectId");
    if (TextUtils.isEmpty(paramContext)) {
      return new String[0];
    }
    return paramContext.split(",");
  }
  
  public static void initSecret(Context paramContext)
  {
    b.a(paramContext);
  }
  
  public static boolean isMainProc(Context paramContext)
  {
    Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = paramContext.getApplicationInfo().processName;
    int i = Process.myPid();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("my.pid -> ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", mainProcessName -> ");
    ((StringBuilder)localObject2).append(paramContext);
    HMSLog.d("BaseUtils", ((StringBuilder)localObject2).toString());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info.pid -> ");
      localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
      localStringBuilder.append(", info.processName -> ");
      localStringBuilder.append(((ActivityManager.RunningAppProcessInfo)localObject2).processName);
      HMSLog.d("BaseUtils", localStringBuilder.toString());
      if ((((ActivityManager.RunningAppProcessInfo)localObject2).pid == i) && (paramContext.equals(((ActivityManager.RunningAppProcessInfo)localObject2).processName))) {
        return true;
      }
    }
    return false;
  }
  
  public static void reportAaidToken(Context paramContext, String paramString)
  {
    n.a(paramContext, paramString);
  }
  
  public static boolean saveCacheData(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return i.a(paramContext).a(paramString1, paramString2);
    }
    return i.a(paramContext).saveString(paramString1, paramString2);
  }
  
  public static void saveProxyInit(Context paramContext, boolean paramBoolean)
  {
    i.a(paramContext).saveBoolean("_proxy_init", paramBoolean);
  }
  
  public static void saveToken(Context paramContext, String paramString1, String paramString2)
  {
    i.a(paramContext).b(paramString1, paramString2);
  }
  
  public static String sendPostRequest(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return d.a(paramContext, paramString1, paramString2, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.aaid.utils.BaseUtils
 * JD-Core Version:    0.7.0.1
 */