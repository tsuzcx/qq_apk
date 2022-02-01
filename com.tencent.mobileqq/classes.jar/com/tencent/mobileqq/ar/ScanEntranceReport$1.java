package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$1
  implements Runnable
{
  ScanEntranceReport$1(ScanEntranceReport paramScanEntranceReport, long paramLong1, long paramLong2, String paramString, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("proc_exist", String.valueOf(ScanEntranceReport.a(this.this$0)));
    localHashMap.put("proc_restart", String.valueOf(ScanEntranceReport.b(this.this$0)));
    localHashMap.put("proc_load_time", String.valueOf(this.a));
    localHashMap.put("activity_launch_time", String.valueOf(this.b));
    localHashMap.put("entry_source", this.c);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_activity_launch", true, this.d, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.1
 * JD-Core Version:    0.7.0.1
 */