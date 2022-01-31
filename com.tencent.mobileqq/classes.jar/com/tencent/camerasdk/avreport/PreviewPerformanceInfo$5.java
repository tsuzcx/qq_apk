package com.tencent.camerasdk.avreport;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ttpic.util.HandlerUtil;

class PreviewPerformanceInfo$5
  implements Runnable
{
  PreviewPerformanceInfo$5(PreviewPerformanceInfo paramPreviewPerformanceInfo) {}
  
  public void run()
  {
    HandlerUtil.waitDone(PreviewPerformanceInfo.access$100(this.this$0));
    PreviewPerformanceInfo.access$100(this.this$0).getLooper().quit();
    PreviewPerformanceInfo.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.PreviewPerformanceInfo.5
 * JD-Core Version:    0.7.0.1
 */