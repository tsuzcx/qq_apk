package com.tencent.av;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class VideoRecoveryReporter$2
  implements Runnable
{
  VideoRecoveryReporter$2(boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_recovery_result2", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.2
 * JD-Core Version:    0.7.0.1
 */