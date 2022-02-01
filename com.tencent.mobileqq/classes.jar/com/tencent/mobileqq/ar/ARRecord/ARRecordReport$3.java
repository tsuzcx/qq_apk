package com.tencent.mobileqq.ar.ARRecord;

import apdf;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARRecordReport$3
  implements Runnable
{
  public ARRecordReport$3(apdf paramapdf, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_record_success", true, 0L, this.jdField_a_of_type_Long, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordReport.3
 * JD-Core Version:    0.7.0.1
 */