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
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("report_key_param_suc", str);
      localHashMap.put("report_key_snapshot_from", String.valueOf(this.jdField_a_of_type_Int));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actAVGameSnapshotFromReport", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("QualityReporter", 2, String.format("reportSnapshotFrom [suc,from]=[%b,%d]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter.1
 * JD-Core Version:    0.7.0.1
 */