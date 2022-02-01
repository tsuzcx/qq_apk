package com.tencent.mobileqq.ark.report;

import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ArkQualityReport
{
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", paramString1);
      localHashMap.put("errorMsg", paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportScriptError, app=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", error=");
      localStringBuilder.append(paramString2);
      QLog.i("ArkApp.Report", 1, localStringBuilder.toString());
      QQBeaconReport.a(paramAppRuntime.getCurrentAccountUin(), "ArkAppScriptError", true, localHashMap, false);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", paramString1);
      localHashMap.put("cmd", paramString2);
      localHashMap.put("usedTime", String.valueOf(paramInt));
      paramString2 = new StringBuilder();
      paramString2.append("reportAppSSOResult, app=");
      paramString2.append(paramString1);
      paramString2.append(", success=");
      paramString2.append(paramBoolean);
      paramString2.append(", usedTime=");
      paramString2.append(paramInt);
      paramString2.append(", params=");
      paramString2.append(localHashMap);
      QLog.i("ArkApp.Report", 1, paramString2.toString());
      QQBeaconReport.a(paramAppRuntime.getCurrentAccountUin(), "ArkSSOMonitor", paramBoolean, localHashMap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.report.ArkQualityReport
 * JD-Core Version:    0.7.0.1
 */