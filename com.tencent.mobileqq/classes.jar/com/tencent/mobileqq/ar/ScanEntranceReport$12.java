package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$12
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("last_total_time", String.valueOf(this.a));
    localHashMap.put("upload_count", String.valueOf(this.b));
    localHashMap.put("session_ids", this.c);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_first_ar_recog", true, this.d, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.12
 * JD-Core Version:    0.7.0.1
 */