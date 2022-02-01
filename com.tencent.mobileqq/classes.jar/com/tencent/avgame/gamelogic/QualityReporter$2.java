package com.tencent.avgame.gamelogic;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class QualityReporter$2
  implements Runnable
{
  public QualityReporter$2(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_topic_count_expect", String.valueOf(this.a));
    localHashMap.put("report_key_topic_count_actual", String.valueOf(this.b));
    localHashMap.put("report_key_topic_count_miss", String.valueOf(this.c));
    localHashMap.put("report_key_param_gametype", String.valueOf(this.d));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAVGameTopicCountReport", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, String.format("reportSnapshotFrom [expect,actual,miss,type]=[%d,%d,%d,%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter.2
 * JD-Core Version:    0.7.0.1
 */