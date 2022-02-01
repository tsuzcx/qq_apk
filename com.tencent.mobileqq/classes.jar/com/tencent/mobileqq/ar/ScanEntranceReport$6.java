package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$6
  implements Runnable
{
  ScanEntranceReport$6(ScanEntranceReport paramScanEntranceReport, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_success", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.6
 * JD-Core Version:    0.7.0.1
 */