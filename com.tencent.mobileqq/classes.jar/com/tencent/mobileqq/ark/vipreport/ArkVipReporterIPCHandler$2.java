package com.tencent.mobileqq.ark.vipreport;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

final class ArkVipReporterIPCHandler$2
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "doVipReport(), sso request failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doVipReport().server.back=");
    localStringBuilder.append(paramObject);
    QLog.d("ArkApp.ArkVipReporterIPCHandler", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporterIPCHandler.2
 * JD-Core Version:    0.7.0.1
 */