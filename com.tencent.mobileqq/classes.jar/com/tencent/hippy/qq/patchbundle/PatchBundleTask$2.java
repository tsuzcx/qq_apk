package com.tencent.hippy.qq.patchbundle;

import java.util.List;

class PatchBundleTask$2
  implements Runnable
{
  PatchBundleTask$2(PatchBundleTask paramPatchBundleTask, PatchBundleConfig.BundleConfigItem paramBundleConfigItem) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$item.mSSOList.size())
    {
      PatchBundleConfig.SSOListConfig localSSOListConfig = (PatchBundleConfig.SSOListConfig)this.val$item.mSSOList.get(i);
      PatchBundleTask.access$300(this.this$0, localSSOListConfig);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.2
 * JD-Core Version:    0.7.0.1
 */