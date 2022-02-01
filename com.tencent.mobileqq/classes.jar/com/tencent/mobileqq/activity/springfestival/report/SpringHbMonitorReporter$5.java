package com.tencent.mobileqq.activity.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import java.util.HashMap;
import java.util.Map;

final class SpringHbMonitorReporter$5
  implements Runnable
{
  SpringHbMonitorReporter$5(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap;
    if (SpringHbMonitorReporter.a(this.jdField_a_of_type_JavaLangString))
    {
      str = QWalletTools.c(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        if (this.b != null) {
          break label100;
        }
        str = "";
        localHashMap.put("ext2", str);
        if (this.c != null) {
          break label108;
        }
      }
    }
    label100:
    label108:
    for (String str = "";; str = this.c)
    {
      localHashMap.put("ext3", str);
      SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_Int, localHashMap, ReportConstant.Res.a(4));
      return;
      str = this.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter.5
 * JD-Core Version:    0.7.0.1
 */