package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class PatchBundleTask$3
  implements PatchBundleConfig.SSOListConfig.OnSSODataFetchListener
{
  PatchBundleTask$3(PatchBundleTask paramPatchBundleTask, int paramInt, PatchBundleConfig.SSOListConfig paramSSOListConfig) {}
  
  public void onFetchDone(int paramInt, PatchBundleConfig.SSOListConfig paramSSOListConfig)
  {
    if (paramInt == 0)
    {
      if ((!TextUtils.isEmpty(paramSSOListConfig.mRsp)) && (this.val$contentHash != paramSSOListConfig.mRsp.hashCode()))
      {
        if (PatchBundleTask.access$400(this.this$0))
        {
          paramSSOListConfig = new ArrayList();
          paramSSOListConfig.add(this.val$config);
          PatchUtils.dispatchSSOData2Page(PatchBundleTask.access$500(this.this$0), paramSSOListConfig);
          QLog.i("PatchBundleTask", 2, "handlePreloadSSO dispatch new sso data");
        }
        else if (!TextUtils.isEmpty(this.val$config.mRsp))
        {
          PatchBundleTask.access$600(this.this$0).put(this.val$config.mKey, this.val$config);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("PatchBundleTask", 2, "handlePreloadSSO sso data the same");
      }
      this.val$config.saveCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.3
 * JD-Core Version:    0.7.0.1
 */