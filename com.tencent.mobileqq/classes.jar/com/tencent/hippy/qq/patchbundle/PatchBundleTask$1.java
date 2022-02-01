package com.tencent.hippy.qq.patchbundle;

import java.util.List;

class PatchBundleTask$1
  implements Runnable
{
  PatchBundleTask$1(PatchBundleTask paramPatchBundleTask, String paramString, PatchBundleConfig.BundleConfigItem paramBundleConfigItem) {}
  
  public void run()
  {
    if (this.val$url.startsWith("http")) {
      PatchBundleTask.access$000(this.this$0, this.val$url);
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.val$item.mPreLoadList.size()) {
        break;
      }
      PatchBundleTask.access$000(this.this$0, (String)this.val$item.mPreLoadList.get(i));
      i += 1;
    }
    while (j < this.val$item.mPrefetchList.size())
    {
      PatchBundleTask.access$100(this.this$0, (String)this.val$item.mPrefetchList.get(j));
      j += 1;
    }
    PatchBundleTask.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.1
 * JD-Core Version:    0.7.0.1
 */