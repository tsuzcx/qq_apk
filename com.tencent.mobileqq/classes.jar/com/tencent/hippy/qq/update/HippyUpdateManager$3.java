package com.tencent.hippy.qq.update;

import android.content.Intent;

class HippyUpdateManager$3
  implements Runnable
{
  HippyUpdateManager$3(HippyUpdateManager paramHippyUpdateManager, HippyUpdateManager.BundleInfo paramBundleInfo, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.cancelDownloadTask(this.val$downloadBundleInfo.bundleName, this.val$downloadBundleInfo.bundleVersion);
    HippyUpdateManager.access$100(this.this$0, this.val$request, this.val$downloadBundleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager.3
 * JD-Core Version:    0.7.0.1
 */