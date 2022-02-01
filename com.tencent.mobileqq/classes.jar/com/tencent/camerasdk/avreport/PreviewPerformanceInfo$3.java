package com.tencent.camerasdk.avreport;

import android.support.annotation.RequiresApi;
import com.tencent.ttpic.baseutils.device.DeviceUtils;

class PreviewPerformanceInfo$3
  implements Runnable
{
  PreviewPerformanceInfo$3(PreviewPerformanceInfo paramPreviewPerformanceInfo, long paramLong) {}
  
  @RequiresApi(api=19)
  public void run()
  {
    PreviewPerformanceInfo localPreviewPerformanceInfo = this.this$0;
    localPreviewPerformanceInfo.total_render_cost += this.val$render_cost;
    localPreviewPerformanceInfo = this.this$0;
    localPreviewPerformanceInfo.render_count += 1L;
    if (this.this$0.counter == 0)
    {
      localPreviewPerformanceInfo = this.this$0;
      localPreviewPerformanceInfo.total_memory += DeviceUtils.getApplicationMemory();
      localPreviewPerformanceInfo = this.this$0;
      localPreviewPerformanceInfo.memory_sample_count += 1L;
      this.this$0.counter = 300;
    }
    localPreviewPerformanceInfo = this.this$0;
    localPreviewPerformanceInfo.counter -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.PreviewPerformanceInfo.3
 * JD-Core Version:    0.7.0.1
 */