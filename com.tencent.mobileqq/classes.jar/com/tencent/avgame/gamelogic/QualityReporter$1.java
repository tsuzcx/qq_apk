package com.tencent.avgame.gamelogic;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QualityReporter$1
  implements Runnable
{
  QualityReporter$1(boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.a) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("report_key_param_suc", str);
    localHashMap.put("report_key_snapshot_from", String.valueOf(this.b));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAVGameSnapshotFromReport", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, String.format("reportSnapshotFrom [suc,from]=[%b,%d]", new Object[] { Boolean.valueOf(this.a), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter.1
 * JD-Core Version:    0.7.0.1
 */