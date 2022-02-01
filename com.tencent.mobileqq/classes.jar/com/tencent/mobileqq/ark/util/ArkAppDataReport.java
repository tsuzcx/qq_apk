package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ArkAppDataReport
{
  static final String[] a = { "PerfGetApp", "PerfCreateView", "PerfDisplayView" };
  static final String[] b = { "ArkAppUpdateMonitor", "ArkAppDisplayMonitor", "ArkHTTPMonitor" };
  
  static long a(Map<String, String> paramMap, String paramString)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramMap);
      return l;
    }
    catch (Exception paramMap) {}
    return 0L;
  }
  
  public static void a(String paramString)
  {
    a(null, paramString, 0, 0, 0, 0, "", "");
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800776F", paramString1, paramInt1, 1, paramInt2, Integer.toString(paramInt3), Integer.toString(paramInt4), paramString2, paramString3);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (Utility.isValidAppName(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ArkAppReportController.a(paramAppRuntime, paramString1, "__platform__", paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramString3, paramString4);
      return;
    }
    QLog.i("ArkApp.DataReport", 1, String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", new Object[] { paramString1, paramString2 }));
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    if (a(paramString2))
    {
      b(paramAppRuntime, paramString1, paramString2, paramBoolean, paramInt, paramMap);
      return;
    }
    if (b(paramString2))
    {
      c(paramAppRuntime, paramString1, paramString2, paramBoolean, paramInt, paramMap);
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("reportArkEngineEvent, ignore event, app=");
    paramAppRuntime.append(paramString1);
    paramAppRuntime.append(", event=");
    paramAppRuntime.append(paramString2);
    paramAppRuntime.append(", success=");
    paramAppRuntime.append(paramBoolean);
    paramAppRuntime.append(", usedTime=");
    paramAppRuntime.append(paramInt);
    paramAppRuntime.append(", params=");
    paramAppRuntime.append(paramMap);
    QLog.i("ArkApp.DataReport", 1, paramAppRuntime.toString());
  }
  
  static boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportArkEngineEventToBigT, app=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", event=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", usedTime=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", params=");
    localStringBuilder.append(paramMap);
    QLog.i("ArkApp.DataReport", 1, localStringBuilder.toString());
    a(paramAppRuntime, paramString1, paramString2, (int)a(paramMap, "result"), (int)a(paramMap, "entry"), paramInt, a(paramMap, "r1"), a(paramMap, "r2"), (String)paramMap.get("r3"), (String)paramMap.get("r4"));
  }
  
  static boolean b(String paramString)
  {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static void c(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportArkEngineEventToBeacon, app=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", event=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", usedTime=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", params=");
    localStringBuilder.append(paramMap);
    QLog.i("ArkApp.DataReport", 1, localStringBuilder.toString());
    paramMap = new HashMap(paramMap);
    paramMap.put("appid", paramString1);
    paramMap.put("usedTime", String.valueOf(paramInt));
    QQBeaconReport.a(paramAppRuntime.getCurrentUin(), paramString2, paramBoolean, paramMap, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.ArkAppDataReport
 * JD-Core Version:    0.7.0.1
 */