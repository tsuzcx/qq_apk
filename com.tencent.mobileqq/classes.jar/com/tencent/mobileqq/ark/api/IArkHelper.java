package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IArkHelper
  extends QRouteApi
{
  public abstract String CopyFileToCache(String paramString1, String paramString2);
  
  public abstract String CopyFileToCache(String paramString, byte[] paramArrayOfByte);
  
  public abstract void cleanAppCache();
  
  public abstract void cleanAppStorage();
  
  public abstract void cleanWebCache();
  
  public abstract String getCacheResPath(String paramString1, String paramString2);
  
  public abstract void preDownloadApp(String paramString1, String paramString2);
  
  public abstract void preloadCommon();
  
  public abstract void reportEvent(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkHelper
 * JD-Core Version:    0.7.0.1
 */