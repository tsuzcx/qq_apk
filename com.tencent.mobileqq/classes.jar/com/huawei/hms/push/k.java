package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

public class k
{
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    PushBaseAnalytics localPushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
    if (localPushBaseAnalytics == null)
    {
      HMSLog.i("PushAnalyticsUtils", "Not support report BI");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("msgId", paramString1);
    localBundle.putString("sdkVer", String.valueOf(50002300));
    localBundle.putString("pkgName", paramContext.getPackageName());
    localBundle.putString("ueid", paramString1);
    localBundle.putString("aaid", HmsInstanceId.getInstance(paramContext).getId());
    localBundle.putString("eventId", paramString2);
    paramString1 = ProxyCenter.getInstance().getProxy();
    if (paramString1 != null) {
      localBundle.putInt("proxyType", paramString1.getProxyType());
    }
    localPushBaseAnalytics.report(paramContext, localBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, o paramo)
  {
    PushBaseAnalytics localPushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
    if (localPushBaseAnalytics == null)
    {
      HMSLog.i("PushAnalyticsUtils", "Not support report BI");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("msgId", paramo.a());
    localBundle.putString("sdkVer", String.valueOf(50002300));
    localBundle.putString("cmd", paramo.j());
    localBundle.putString("pkgName", paramContext.getPackageName());
    localBundle.putString("notifyId", paramString2);
    localBundle.putString("ueid", paramo.w());
    localBundle.putString("aaid", HmsInstanceId.getInstance(paramContext).getId());
    localBundle.putString("eventId", paramString1);
    paramString1 = ProxyCenter.getInstance().getProxy();
    if (paramString1 != null) {
      localBundle.putInt("proxyType", paramString1.getProxyType());
    }
    localPushBaseAnalytics.report(paramContext, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.k
 * JD-Core Version:    0.7.0.1
 */