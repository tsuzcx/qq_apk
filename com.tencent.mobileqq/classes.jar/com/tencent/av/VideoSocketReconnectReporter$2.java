package com.tencent.av;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class VideoSocketReconnectReporter$2
  implements Runnable
{
  VideoSocketReconnectReporter$2(int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("policy_type", String.valueOf(this.a));
    localHashMap.put("net_type", String.valueOf(this.b));
    localHashMap.put("time_cost", String.valueOf(this.c));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_socket_recon_result2", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter.2
 * JD-Core Version:    0.7.0.1
 */