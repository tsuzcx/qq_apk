package com.tencent.mobileqq.activity.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import java.util.HashMap;
import java.util.Map;

final class SpringHbMonitorReporter$4
  implements Runnable
{
  SpringHbMonitorReporter$4(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String str2;
    String str3;
    if (SpringHbMonitorReporter.a(this.jdField_a_of_type_JavaLangString))
    {
      String str1 = QWalletTools.c(this.jdField_a_of_type_JavaLangString);
      str2 = SpringHbMonitorReporter.a(719) + "";
      str3 = SpringHbMonitorReporter.b(719) + "";
      if (!TextUtils.isEmpty(str1))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str1);
        localHashMap.put("ext2", str2);
        localHashMap.put("ext3", str3);
        localHashMap.put("ext4", this.jdField_a_of_type_Int + "");
        SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 3, this.b, localHashMap, ReportConstant.Res.a(3));
      }
      if (this.b != 0) {
        break label177;
      }
      SpringHbMonitorReporter.a();
    }
    label177:
    while (this.jdField_a_of_type_Int != 404) {
      return;
    }
    SpringHbMonitorReporter.a(this.jdField_a_of_type_JavaLangString, 1, true, str2, str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.4
 * JD-Core Version:    0.7.0.1
 */