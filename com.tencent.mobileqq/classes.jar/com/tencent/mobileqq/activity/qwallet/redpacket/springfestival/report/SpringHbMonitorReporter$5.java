package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import agvm;
import agvn;
import agvs;
import agwj;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class SpringHbMonitorReporter$5
  implements Runnable
{
  public SpringHbMonitorReporter$5(String paramString, int paramInt) {}
  
  public void run()
  {
    if (agvn.a(this.jdField_a_of_type_JavaLangString))
    {
      String str = agwj.c(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        agvs.a(agvm.jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_Int, localHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.5
 * JD-Core Version:    0.7.0.1
 */