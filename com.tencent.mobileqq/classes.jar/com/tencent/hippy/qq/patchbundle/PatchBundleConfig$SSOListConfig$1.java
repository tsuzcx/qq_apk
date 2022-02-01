package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;

class PatchBundleConfig$SSOListConfig$1
  implements Runnable
{
  PatchBundleConfig$SSOListConfig$1(PatchBundleConfig.SSOListConfig paramSSOListConfig, PatchBundleConfig.SSOListConfig.OnSSODataFetchListener paramOnSSODataFetchListener) {}
  
  public void run()
  {
    if ("https".equals(this.this$0.mType)) {
      PatchBundleConfig.SSOListConfig.access$100(this.this$0);
    }
    PatchBundleConfig.SSOListConfig.OnSSODataFetchListener localOnSSODataFetchListener = this.val$onSSODataFetchListener;
    if (localOnSSODataFetchListener != null)
    {
      int i;
      if (!TextUtils.isEmpty(this.this$0.mRsp)) {
        i = 0;
      } else {
        i = -1;
      }
      localOnSSODataFetchListener.onFetchDone(i, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig.SSOListConfig.1
 * JD-Core Version:    0.7.0.1
 */