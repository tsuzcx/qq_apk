package com.tencent.avgame.gamelogic;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class QualityReporter$3
  implements Runnable
{
  QualityReporter$3(long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAVGameHeartBeat", true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter.3
 * JD-Core Version:    0.7.0.1
 */