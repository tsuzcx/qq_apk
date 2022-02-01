package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ScanEntranceReport$10
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_name", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("memory_size", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_average_fps", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.10
 * JD-Core Version:    0.7.0.1
 */