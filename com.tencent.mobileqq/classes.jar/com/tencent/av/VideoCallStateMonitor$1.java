package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class VideoCallStateMonitor$1
  implements Runnable
{
  VideoCallStateMonitor$1(VideoCallStateMonitor paramVideoCallStateMonitor, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(VideoCallStateMonitor.a(this.this$0).getCurrentAccountUin(), "av_memory_details", true, 0L, 0L, this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */