package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.ark.util.ArkAppCrashProtect;
import com.tencent.qphone.base.util.QLog;

class ArkAppPreDownloadMgr$3
  implements ArkAppPreloader.PreloadAppCallback
{
  ArkAppPreDownloadMgr$3(ArkAppPreDownloadMgr paramArkAppPreDownloadMgr) {}
  
  public void beginAppload(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      ArkAppCrashProtect.a(paramString);
    }
  }
  
  public void onAppLoaded(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      ArkAppCrashProtect.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preload app appname=", paramString, ",success=", Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void onReleaseAndReload(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("profiling onReleaseAndReload begin app = ");
    localStringBuilder.append(paramString);
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, localStringBuilder.toString());
    ArkAppMgr.getInstance().getAppPathByName(paramString, "0.0.0.1", new ArkAppPreDownloadMgr.3.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */