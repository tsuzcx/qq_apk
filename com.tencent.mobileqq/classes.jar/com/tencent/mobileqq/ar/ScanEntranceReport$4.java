package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$4
  implements Runnable
{
  ScanEntranceReport$4(ScanEntranceReport paramScanEntranceReport, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.a));
    localHashMap.put("start_delay", String.valueOf(this.b));
    localHashMap.put("first_select_time", String.valueOf(this.c));
    localHashMap.put("first_upload_delay", String.valueOf(this.d));
    localHashMap.put("neon_opened", String.valueOf(this.e));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_ar_cloud_first_upload", true, this.f, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.4
 * JD-Core Version:    0.7.0.1
 */