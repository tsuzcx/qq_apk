package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.api.PackageUpdateListener;

class HippyQQUpdateManager$2
  implements Runnable
{
  HippyQQUpdateManager$2(HippyQQUpdateManager paramHippyQQUpdateManager, String paramString1, String paramString2, PackageUpdateListener paramPackageUpdateListener) {}
  
  public void run()
  {
    HippyQQFileUtil.downLoad(this.val$bundleUrl, HippyQQFileUtil.getZipFile(this.val$moduleName, 2147483646), new HippyQQUpdateManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */