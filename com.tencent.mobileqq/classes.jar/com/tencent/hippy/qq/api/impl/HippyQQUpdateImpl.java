package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyQQUpdate;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;

public class HippyQQUpdateImpl
  implements IHippyQQUpdate
{
  public void checkUpdate(String paramString, PackageUpdateListener paramPackageUpdateListener)
  {
    new HippyQQUpdateManager().checkUpdate(paramString, paramPackageUpdateListener);
  }
  
  public void loadOnlineBundle(String paramString1, String paramString2, PackageUpdateListener paramPackageUpdateListener)
  {
    new HippyQQUpdateManager().loadOnlineBundle(paramString1, paramString2, paramPackageUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyQQUpdateImpl
 * JD-Core Version:    0.7.0.1
 */