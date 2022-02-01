package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkEnvironmentManager.IDataReport;
import com.tencent.mobileqq.ark.util.ArkAppDataReport;
import java.util.Map;
import mqq.app.MobileQQ;

final class ArkEnvironment$4
  implements ArkEnvironmentManager.IDataReport
{
  public void report(String paramString1, String paramString2, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    ArkAppDataReport.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString1, paramString2, paramBoolean, paramInt, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment.4
 * JD-Core Version:    0.7.0.1
 */