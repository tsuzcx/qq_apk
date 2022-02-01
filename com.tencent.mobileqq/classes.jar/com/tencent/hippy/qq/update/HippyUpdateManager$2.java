package com.tencent.hippy.qq.update;

import android.content.Intent;
import com.tencent.hippy.qq.update.sso.BundleInfo;

class HippyUpdateManager$2
  implements Runnable
{
  HippyUpdateManager$2(HippyUpdateManager paramHippyUpdateManager, BundleInfo paramBundleInfo, Intent paramIntent) {}
  
  public void run()
  {
    HippyPredownloadManager.getInstance().cancelDownloadTask(this.val$downloadBundleInfo.bundleName, this.val$downloadBundleInfo.bundleVersion);
    int i = this.val$request.getIntExtra("curVersion", -1);
    HippyUpdateManager localHippyUpdateManager = this.this$0;
    Intent localIntent = this.val$request;
    BundleInfo localBundleInfo = this.val$downloadBundleInfo;
    HippyUpdateManager.access$100(localHippyUpdateManager, localIntent, localBundleInfo, localBundleInfo.canDiffUpdate(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */