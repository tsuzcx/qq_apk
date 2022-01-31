package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import ahib;
import ahic;
import ahih;
import ahiy;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class SpringHbMonitorReporter$5
  implements Runnable
{
  public SpringHbMonitorReporter$5(String paramString, int paramInt) {}
  
  public void run()
  {
    if (ahic.a(this.jdField_a_of_type_JavaLangString))
    {
      String str = ahiy.c(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        ahih.a(ahib.jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_Int, localHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.5
 * JD-Core Version:    0.7.0.1
 */