package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.hippy.qq.api.PackageUpdateListener;

class HippyUpdateManager$1
  implements PackageUpdateListener
{
  HippyUpdateManager$1(HippyUpdateManager paramHippyUpdateManager, Bundle paramBundle, String paramString) {}
  
  public void onUpdateComplete(int paramInt, String paramString1, String paramString2)
  {
    paramString2 = new Intent();
    paramString2.putExtras(this.val$extra);
    HippyUpdateManager.access$000(this.this$0, paramString2, this.val$bundleName, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */