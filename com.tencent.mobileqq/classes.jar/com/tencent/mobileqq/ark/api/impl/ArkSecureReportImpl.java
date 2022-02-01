package com.tencent.mobileqq.ark.api.impl;

import android.net.Uri;
import android.util.Pair;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.secure.ArkSecurityReporter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkSecureReportImpl
  implements IArkSecureReport
{
  static final String TAG = "ArkApp.SecureReport";
  static final int URL_TYPE_RES = 1;
  static final int URL_TYPE_WEB = 2;
  
  static Pair<String, String> getUrlSchemePath(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getAuthority());
      localStringBuilder.append(paramString.getPath());
      paramString = new Pair(localObject, localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUrlPath fail, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ArkApp.SecureReport", 1, ((StringBuilder)localObject).toString());
    }
    return new Pair("", "");
  }
  
  static void reportArkCheckURLMonitor(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
    Pair localPair = getUrlSchemePath(paramString2);
    paramString2 = new HashMap();
    paramString2.put("appid", paramString1);
    paramString2.put("scheme", localPair.first);
    paramString2.put("url", localPair.second);
    paramString2.put("urlType", String.valueOf(paramInt1));
    paramString2.put("result", String.valueOf(paramInt2));
    QQBeaconReport.a(str, "ArkURLCheckMonitor", paramString2);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportArkCheckURLMonitor, uin=");
      paramString1.append(str);
      paramString1.append(", params=");
      paramString1.append(paramString2.toString());
      QLog.d("ArkApp.SecureReport", 2, paramString1.toString());
    }
  }
  
  public void reportAccumulatedValidURL(String paramString)
  {
    ArkSecurityReporter.a(paramString);
  }
  
  public void reportNavigateURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ArkSecurityReporter.c(paramString1, paramString2, paramInt1, paramInt2, paramString3);
  }
  
  public void reportOpenURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ArkSecurityReporter.b(paramString1, paramString2, paramInt1, paramInt2, paramString3);
    reportArkCheckURLMonitor(paramString1, paramString2, 2, paramInt2);
  }
  
  public void reportResourceURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ArkSecurityReporter.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
    reportArkCheckURLMonitor(paramString1, paramString2, 1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkSecureReportImpl
 * JD-Core Version:    0.7.0.1
 */