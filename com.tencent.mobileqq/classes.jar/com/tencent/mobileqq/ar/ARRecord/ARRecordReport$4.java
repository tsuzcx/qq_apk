package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARRecordReport$4
  implements Runnable
{
  ARRecordReport$4(ARRecordReport paramARRecordReport, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_record_fail", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.4
 * JD-Core Version:    0.7.0.1
 */