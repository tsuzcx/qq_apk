package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.BusinessObserver;

class ArkAppCGI$15
  implements BusinessObserver
{
  ArkAppCGI$15(ArkAppCGI paramArkAppCGI) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "doVipReport(), sso request failed");
      return;
    }
    ArkAppCenter.b("ArkApp.ArkAppCGI", "doVipReport().server.back=" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.15
 * JD-Core Version:    0.7.0.1
 */