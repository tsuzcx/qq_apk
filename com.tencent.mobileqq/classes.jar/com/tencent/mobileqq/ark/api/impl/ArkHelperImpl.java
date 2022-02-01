package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.util.ArkAppDataUtil;
import com.tencent.mobileqq.ark.util.ArkLocalCacheUtil;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ArkHelperImpl
  implements IArkHelper
{
  private static final String TAG = "ArkApp.ArkHelper";
  
  public String CopyFileToCache(String paramString1, String paramString2)
  {
    return ArkAppDataUtil.a(paramString1, paramString2);
  }
  
  public String CopyFileToCache(String paramString, byte[] paramArrayOfByte)
  {
    return ArkAppDataUtil.a(paramString, paramArrayOfByte);
  }
  
  public void cleanAppCache() {}
  
  public void cleanAppStorage() {}
  
  public void cleanWebCache() {}
  
  public String getCacheResPath(String paramString1, String paramString2)
  {
    return ArkAppDataUtil.b(paramString1, paramString2);
  }
  
  public void preDownloadApp(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkHelper", 2, new Object[] { "preDownloadArkApp download start,appName: ", paramString1, ",appView=", paramString2 });
    }
    ArkAppMgr.getInstance().getAppPathByName(paramString1, "0.0.0.1", new ArkHelperImpl.1(this));
  }
  
  public void preloadCommon() {}
  
  public void reportEvent(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    ArkAppReportController.a(paramAppRuntime, paramString1, paramString2, paramString3, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString4, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkHelperImpl
 * JD-Core Version:    0.7.0.1
 */