package com.tencent.aekit.api.standard.filter;

import com.tencent.ttpic.baseutils.log.LogUtils;

class AEFilterManager$2
  implements Runnable
{
  AEFilterManager$2(AEFilterManager paramAEFilterManager) {}
  
  public void run()
  {
    if (AEFilterManager.access$100(this.this$0) == null)
    {
      AEFilterManager.access$102(this.this$0, new AEFaceTransform());
      LogUtils.i("AEFilterManager", "create faceTransform action done");
    }
    if ((AEFilterManager.access$200(this.this$0)) && (AEFilterManager.access$100(this.this$0) != null))
    {
      LogUtils.i("AEFilterManager", "create faceTransform action done, but GLThread has exited, so do cleaning");
      AEFilterManager.access$100(this.this$0).clear();
      AEFilterManager.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.2
 * JD-Core Version:    0.7.0.1
 */