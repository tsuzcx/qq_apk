package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

class ArkAppCGI$4
  implements BusinessObserver
{
  ArkAppCGI$4(ArkAppCGI paramArkAppCGI) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkApp.ArkAppCGI", 1, "ArkSafe,doReport, sso request failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkSafe.doReport.server.back=");
    localStringBuilder.append(paramObject);
    QLog.d("ArkApp.ArkAppCGI", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI.4
 * JD-Core Version:    0.7.0.1
 */