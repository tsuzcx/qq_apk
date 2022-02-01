package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.ark.secure.ArkSecurityReporter;

public class ArkSecureReportImpl
  implements IArkSecureReport
{
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
  }
  
  public void reportResourceURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ArkSecurityReporter.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkSecureReportImpl
 * JD-Core Version:    0.7.0.1
 */