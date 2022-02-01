package com.tencent.avgame.gamelogic.gameres;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

final class CJPreloadMonitorReporter$2
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        CJPreloadMonitorReporter.OfflineReportInfo localOfflineReportInfo = CJPreloadMonitorReporter.a(BaseApplicationImpl.sApplication.getRuntime());
        String str1 = localOfflineReportInfo.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i("CJPreloadMonitorReporter", 2, "[reportConfigCoverageDaily] bids: " + str1);
        }
        if (Utils.a(this.jdField_a_of_type_JavaLangString, str1))
        {
          Object localObject = CJPreloadMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Int != 0) {
            break label344;
          }
          bool = true;
          String str2 = CJPreloadMonitorReporter.a(bool, this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("CJPreloadMonitorReporter", 2, "[offlinePackageReport] currReportTag == " + str2 + " lastReportTag: " + (String)localObject);
          }
          if (((String)localObject).equals(str2)) {
            return;
          }
          localObject = new HashMap();
          ((Map)localObject).put("ext1", "" + this.jdField_a_of_type_JavaLangString);
          ((Map)localObject).put("ext2", "" + localOfflineReportInfo.jdField_a_of_type_Int);
          ((Map)localObject).put("ext3", "" + localOfflineReportInfo.b);
          ((Map)localObject).put("ext4", "" + this.b);
          SpringHbReporter.a(ReportConstant.Event.c, 2, this.jdField_a_of_type_Int, (Map)localObject, "", false);
          CJPreloadMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), str2, this.jdField_a_of_type_JavaLangString);
          CJPreloadMonitorReporter.a(str1, localOfflineReportInfo.jdField_a_of_type_Int, localOfflineReportInfo.b);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CJPreloadMonitorReporter", 1, localThrowable, new Object[0]);
      }
      return;
      label344:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter.2
 * JD-Core Version:    0.7.0.1
 */