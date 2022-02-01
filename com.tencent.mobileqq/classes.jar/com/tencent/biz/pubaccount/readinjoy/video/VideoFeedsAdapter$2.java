package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import java.util.HashMap;

class VideoFeedsAdapter$2
  implements Runnable
{
  VideoFeedsAdapter$2(VideoFeedsAdapter paramVideoFeedsAdapter, long paramLong) {}
  
  public void run()
  {
    if (VideoFeedsAdapter.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      RIJStatisticCollectorReport.e(VideoFeedsAdapter.a(this.this$0), ReadInJoyUtils.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */