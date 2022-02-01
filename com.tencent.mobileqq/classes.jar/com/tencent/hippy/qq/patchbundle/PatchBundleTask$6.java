package com.tencent.hippy.qq.patchbundle;

import java.util.List;

class PatchBundleTask$6
  implements PatchBundleTask.OnLoadPatchBundleListener
{
  PatchBundleTask$6(PatchBundleTask paramPatchBundleTask) {}
  
  public void onLoad(String paramString1, int paramInt, String paramString2)
  {
    if (PatchBundleTask.access$800(this.this$0).isEmpty()) {
      PatchBundleTask.access$902(this.this$0, false);
    }
    if (paramInt == 0)
    {
      PatchBundleTask.access$1000(this.this$0);
      return;
    }
    PatchBundleTask.access$902(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.6
 * JD-Core Version:    0.7.0.1
 */