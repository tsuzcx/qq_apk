package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$8
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("upload_count", String.valueOf(this.a));
    localHashMap.put("zoom_count", String.valueOf(this.b));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_qr_success", true, this.c, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.8
 * JD-Core Version:    0.7.0.1
 */