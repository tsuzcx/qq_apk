package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkQualityReport;
import com.tencent.mobileqq.ark.report.ArkQualityReport;
import mqq.app.AppRuntime;

public class ArkQualityReportImpl
  implements IArkQualityReport
{
  public void reportAppSSOResult(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    ArkQualityReport.a(paramAppRuntime, paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void reportScriptError(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    ArkQualityReport.a(paramAppRuntime, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkQualityReportImpl
 * JD-Core Version:    0.7.0.1
 */