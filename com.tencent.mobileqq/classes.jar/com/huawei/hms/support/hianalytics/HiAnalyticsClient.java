package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsClient
  extends a
{
  @Deprecated
  public static String reportEntry(Context paramContext, String paramString)
  {
    return reportEntry(paramContext, paramString, Util.getAppId(paramContext), 0);
  }
  
  public static String reportEntry(Context paramContext, String paramString, int paramInt)
  {
    return reportEntry(paramContext, paramString, Util.getAppId(paramContext), paramInt);
  }
  
  public static String reportEntry(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    String str = TransactionIdCreater.getId(paramString2, paramString1);
    paramString1 = a.getMapForBi(paramContext, paramString1);
    paramString1.put("appid", paramString2);
    paramString1.put("transId", str);
    paramString1.put("direction", "req");
    paramString1.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramInt)));
    paramString1.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_KIT_API_CALLED", paramString1);
    return str;
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    reportExit(paramContext, paramString1, paramString2, Util.getAppId(paramContext), paramInt1, paramInt2, 0);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    reportExit(paramContext, paramString1, paramString2, Util.getAppId(paramContext), paramInt1, paramInt2, paramInt3);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString1 = a.getMapForBi(paramContext, paramString1);
    paramString1.put("appid", paramString3);
    paramString1.put("transId", paramString2);
    paramString1.put("direction", "rsp");
    paramString1.put("statusCode", String.valueOf(paramInt1));
    paramString1.put("result", String.valueOf(paramInt2));
    paramString1.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramInt3)));
    paramString1.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_KIT_API_CALLED", paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.HiAnalyticsClient
 * JD-Core Version:    0.7.0.1
 */