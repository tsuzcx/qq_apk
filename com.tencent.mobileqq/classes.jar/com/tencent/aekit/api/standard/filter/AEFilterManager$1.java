package com.tencent.aekit.api.standard.filter;

import com.tencent.ttpic.baseutils.log.LogUtils;

class AEFilterManager$1
  implements Runnable
{
  AEFilterManager$1(AEFilterManager paramAEFilterManager) {}
  
  public void run()
  {
    if (AEFilterManager.access$000(this.this$0) == null)
    {
      AEFilterManager.access$002(this.this$0, new AEFaceTransform());
      LogUtils.i(AEFilterManager.access$100(), "create faceTransform action done");
    }
    if ((AEFilterManager.access$200(this.this$0)) && (AEFilterManager.access$000(this.this$0) != null))
    {
      LogUtils.i(AEFilterManager.access$100(), "create faceTransform action done, but GLThread has exited, so do cleaning");
      AEFilterManager.access$000(this.this$0).clear();
      AEFilterManager.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.1
 * JD-Core Version:    0.7.0.1
 */