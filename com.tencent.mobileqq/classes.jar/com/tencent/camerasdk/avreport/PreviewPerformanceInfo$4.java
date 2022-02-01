package com.tencent.camerasdk.avreport;

class PreviewPerformanceInfo$4
  implements Runnable
{
  PreviewPerformanceInfo$4(PreviewPerformanceInfo paramPreviewPerformanceInfo) {}
  
  public void run()
  {
    int j = 0;
    if (this.this$0.render_count != 0L) {}
    for (int i = (int)(this.this$0.total_render_cost / this.this$0.render_count);; i = 0)
    {
      if (this.this$0.memory_sample_count != 0L) {
        j = (int)(this.this$0.total_memory / this.this$0.memory_sample_count);
      }
      AEKitBean localAEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_PERFORMANCE.value);
      localAEKitBean.ext_int1 = Integer.valueOf(this.this$0.render_width);
      localAEKitBean.ext_int2 = Integer.valueOf(this.this$0.render_height);
      localAEKitBean.ext_int3 = Integer.valueOf(i);
      localAEKitBean.ext_int4 = Integer.valueOf((int)this.this$0.render_count);
      localAEKitBean.ext_int5 = Integer.valueOf(j);
      localAEKitBean.ext_str1 = this.this$0.sticker_id;
      AVReportCenter.getInstance().commit(localAEKitBean, Boolean.valueOf(true));
      AVRLogUtils.d("PreviewPerformanceInfo", localAEKitBean.toString());
      PreviewPerformanceInfo.access$000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.PreviewPerformanceInfo.4
 * JD-Core Version:    0.7.0.1
 */