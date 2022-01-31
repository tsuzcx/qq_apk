package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import agsy;
import agvm;
import agvn;
import agvo;
import agvs;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public final class SpringHbMonitorReporter$2
  implements Runnable
{
  public SpringHbMonitorReporter$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        agvo localagvo = agvn.a(BaseApplicationImpl.sApplication.getRuntime());
        String str1 = localagvo.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[reportConfigCoverageDaily] bids: " + str1);
        }
        if (agsy.a(this.jdField_a_of_type_JavaLangString, str1))
        {
          Object localObject = agvn.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Int != 0) {
            break label342;
          }
          bool = true;
          String str2 = agvn.a(bool, this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("springHb_report_SpringHbMonitorReporter", 2, "[offlinePackageReport] currReportTag == " + str2 + " lastReportTag: " + (String)localObject);
          }
          if (((String)localObject).equals(str2)) {
            return;
          }
          localObject = new HashMap();
          ((Map)localObject).put("ext1", "" + this.jdField_a_of_type_JavaLangString);
          ((Map)localObject).put("ext2", "" + localagvo.jdField_a_of_type_Int);
          ((Map)localObject).put("ext3", "" + localagvo.b);
          ((Map)localObject).put("ext4", "" + this.b);
          agvs.a(agvm.c, 2, this.jdField_a_of_type_Int, (Map)localObject, false);
          agvn.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), str2, this.jdField_a_of_type_JavaLangString);
          agvn.b(str1, localagvo.jdField_a_of_type_Int, localagvo.b);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_report_SpringHbMonitorReporter", 1, localThrowable, new Object[0]);
      }
      return;
      label342:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.2
 * JD-Core Version:    0.7.0.1
 */