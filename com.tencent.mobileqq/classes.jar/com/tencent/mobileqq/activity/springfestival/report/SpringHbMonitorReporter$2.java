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
        String str = localOfflineReportInfo.jdField_a_of_type_JavaLangString;
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[reportConfigCoverageDaily] bids: ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("shua2021report_SpringHbMonitorReporter", 2, ((StringBuilder)localObject1).toString());
        }
        if (Utils.a(this.jdField_a_of_type_JavaLangString, str))
        {
          Object localObject2 = SpringHbMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Int != 0) {
            break label413;
          }
          bool = true;
          localObject1 = SpringHbMonitorReporter.a(bool, this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[offlinePackageReport] currReportTag == ");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" lastReportTag: ");
            localStringBuilder.append((String)localObject2);
            QLog.i("shua2021report_SpringHbMonitorReporter", 2, localStringBuilder.toString());
          }
          if (((String)localObject2).equals(localObject1)) {
            return;
          }
          localObject2 = new HashMap();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          ((Map)localObject2).put("ext1", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(localOfflineReportInfo.jdField_a_of_type_Int);
          ((Map)localObject2).put("ext2", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(localOfflineReportInfo.b);
          ((Map)localObject2).put("ext3", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.b);
          ((Map)localObject2).put("ext4", localStringBuilder.toString());
          SpringHbReporter.a(ReportConstant.Event.c, 2, this.jdField_a_of_type_Int, (Map)localObject2, "", false);
          SpringHbMonitorReporter.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, this.jdField_a_of_type_JavaLangString);
          SpringHbMonitorReporter.b(str, localOfflineReportInfo.jdField_a_of_type_Int, localOfflineReportInfo.b);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("shua2021report_SpringHbMonitorReporter", 1, localThrowable, new Object[0]);
      }
      return;
      label413:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.2
 * JD-Core Version:    0.7.0.1
 */