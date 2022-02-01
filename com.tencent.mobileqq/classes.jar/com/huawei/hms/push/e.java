package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

public class e
{
  public static final String a = "e";
  
  public static Bundle a(Context paramContext, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("sdkVer", String.valueOf(50101300));
    localBundle.putString("pkgName", paramContext.getPackageName());
    localBundle.putString("aaid", HmsInstanceId.getInstance(paramContext).getId());
    paramContext = ProxyCenter.getProxy();
    if (paramContext != null) {
      localBundle.putString("proxyType", paramContext.getProxyType());
    }
    localBundle.putString("msgId", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("analyticInfo", paramString2);
    }
    return localBundle;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    PushBaseAnalytics localPushBaseAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
    if (localPushBaseAnalytics == null) {
      return;
    }
    paramString1 = a(paramContext, paramString1, paramString2);
    paramString2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("eventId:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(",UserProfiles:");
    localStringBuilder.append(paramString1.toString());
    HMSLog.i(paramString2, localStringBuilder.toString());
    localPushBaseAnalytics.report(paramContext, paramString3, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.e
 * JD-Core Version:    0.7.0.1
 */