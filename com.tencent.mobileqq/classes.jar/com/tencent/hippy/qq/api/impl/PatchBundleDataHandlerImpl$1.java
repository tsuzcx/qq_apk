package com.tencent.hippy.qq.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.hippy.qq.patchbundle.PatchBundleConfig;
import com.tencent.hippy.qq.patchbundle.PatchUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PatchBundleDataHandlerImpl$1
  implements PatchBundleDataHandlerImpl.OnDownloadListener
{
  PatchBundleDataHandlerImpl$1(PatchBundleDataHandlerImpl paramPatchBundleDataHandlerImpl, SharedPreferences paramSharedPreferences, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  public void onDownloadResult(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.val$sharedPreferences.edit().putLong("last_check_config_ts", System.currentTimeMillis()).apply();
    }
    StringBuilder localStringBuilder;
    if ((paramInt1 != 304) && (paramInt2 == 0))
    {
      PatchBundleDataHandlerImpl.access$000(this.this$0).parseConfig(new File(PatchUtils.getConfigFilePath()));
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpCode :");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" result:");
      localStringBuilder.append(paramInt2);
      QLog.i("PatchBundleDataHandlerImpl", 1, localStringBuilder.toString());
    }
    if (this.val$preloadBundle) {
      PatchBundleDataHandlerImpl.access$000(this.this$0).preloadBundleList();
    }
    if (this.val$loadSSOCache) {
      PatchBundleDataHandlerImpl.access$000(this.this$0).loadSSOListCache();
    }
    PatchBundleDataHandlerImpl.access$102(true);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadConfig use ");
      localStringBuilder.append(System.currentTimeMillis() - this.val$startTime);
      QLog.d("PatchBundleDataHandlerImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.PatchBundleDataHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */