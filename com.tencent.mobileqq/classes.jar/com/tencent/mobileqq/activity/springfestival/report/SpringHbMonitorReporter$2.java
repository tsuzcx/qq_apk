package com.tencent.mobileqq.activity.springfestival.report;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

final class SpringHbMonitorReporter$2
  implements Runnable
{
  SpringHbMonitorReporter$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        SpringHbMonitorReporter.OfflineReportInfo localOfflineReportInfo = SpringHbMonitorReporter.a(BaseApplicationImpl.sApplication.getRuntime());
        String str1 = localOfflineReportInfo.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] bids: " + str1);
        }
        if (Utils.a(this.jdField_a_of_type_JavaLangString, str1))
        {
          Object localObject = SpringHbMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Int != 0) {
            break label344;
          }
          bool = true;
          String str2 = SpringHbMonitorReporter.a(bool, this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("shua2021report_SpringHbMonitorReporter", 2, "[offlinePackageReport] currReportTag == " + str2 + " lastReportTag: " + (String)localObject);
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
          SpringHbMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), str2, this.jdField_a_of_type_JavaLangString);
          SpringHbMonitorReporter.b(str1, localOfflineReportInfo.jdField_a_of_type_Int, localOfflineReportInfo.b);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("shua2021report_SpringHbMonitorReporter", 1, localThrowable, new Object[0]);
      }
      return;
      label344:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.2
 * JD-Core Version:    0.7.0.1
 */