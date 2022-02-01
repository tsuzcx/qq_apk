package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;

class ArkAppCGI$14
  implements BusinessObserver
{
  ArkAppCGI$14(ArkAppCGI paramArkAppCGI) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport, sso request failed");
      return;
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", "ArkSafe.doReport.server.back=" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.14
 * JD-Core Version:    0.7.0.1
 */