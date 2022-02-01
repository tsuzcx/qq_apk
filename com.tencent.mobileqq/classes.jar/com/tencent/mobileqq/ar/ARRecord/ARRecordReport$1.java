package com.tencent.mobileqq.ar.ARRecord;

import apdf;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$1
  implements Runnable
{
  public ARRecordReport$1(apdf paramapdf) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_pre_record_start", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.1
 * JD-Core Version:    0.7.0.1
 */