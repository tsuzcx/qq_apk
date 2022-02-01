package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARRecordReport$1
  implements Runnable
{
  ARRecordReport$1(ARRecordReport paramARRecordReport) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_pre_record_start", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.1
 * JD-Core Version:    0.7.0.1
 */