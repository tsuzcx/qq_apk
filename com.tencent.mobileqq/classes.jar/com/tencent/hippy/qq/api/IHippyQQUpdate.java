package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHippyQQUpdate
  extends QRouteApi
{
  public abstract void checkUpdate(String paramString, PackageUpdateListener paramPackageUpdateListener);
  
  public abstract void loadOnlineBundle(String paramString1, String paramString2, PackageUpdateListener paramPackageUpdateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyQQUpdate
 * JD-Core Version:    0.7.0.1
 */