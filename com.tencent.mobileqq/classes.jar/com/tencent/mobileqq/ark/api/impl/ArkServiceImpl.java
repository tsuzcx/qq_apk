package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.core.ArkAppSSO;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ArkServiceImpl
  implements IArkService
{
  private static final String TAG = "ArkApp.ArkService";
  ArkAppCenter arkAppCenter;
  
  public void doURLReport(String paramString)
  {
    ArkAppCenter localArkAppCenter = this.arkAppCenter;
    if (localArkAppCenter == null)
    {
      QLog.i("ArkApp.ArkService", 1, "doURLReport: arkAppCenter is null");
      return;
    }
    localArkAppCenter.j().a(paramString);
  }
  
  public IArkAppSSO getSSO()
  {
    ArkAppCenter localArkAppCenter = this.arkAppCenter;
    if (localArkAppCenter == null)
    {
      QLog.i("ArkApp.ArkService", 1, "getSSO: arkAppCenter is null");
      return null;
    }
    return localArkAppCenter.k();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.arkAppCenter = new ArkAppCenter(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    QLog.i("ArkApp.ArkService", 1, "onDestroy");
    this.arkAppCenter.e();
    this.arkAppCenter = null;
  }
  
  public void reportPredownloadFirstHit(String paramString, boolean paramBoolean)
  {
    ArkAppCenter localArkAppCenter = this.arkAppCenter;
    if (localArkAppCenter == null)
    {
      QLog.i("ArkApp.ArkService", 1, "reportPredownloadFirstHit: arkAppCenter is null");
      return;
    }
    localArkAppCenter.l().a(paramString, paramBoolean);
  }
  
  public void sendAppMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    ArkAppCenter localArkAppCenter = this.arkAppCenter;
    if (localArkAppCenter == null)
    {
      QLog.i("ArkApp.ArkService", 1, "sendAppMsg: arkAppCenter is null");
      if (paramBusinessObserver != null) {
        paramBusinessObserver.onUpdate(paramInt2, false, null);
      }
      return;
    }
    localArkAppCenter.k().a(paramString1, paramString2, paramInt1, paramInt2, paramBusinessObserver);
  }
  
  public void startPreloadApp()
  {
    ArkAppCenter localArkAppCenter = this.arkAppCenter;
    if (localArkAppCenter == null) {
      return;
    }
    localArkAppCenter.l().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkServiceImpl
 * JD-Core Version:    0.7.0.1
 */