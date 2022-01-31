package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import agvm;
import agvn;
import agvs;
import agwj;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class SpringHbMonitorReporter$4
  implements Runnable
{
  public SpringHbMonitorReporter$4(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (agvn.a(this.jdField_a_of_type_JavaLangString))
    {
      String str = agwj.c(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        localHashMap.put("ext2", agvn.a(539) + "");
        localHashMap.put("ext3", agvn.b(539) + "");
        localHashMap.put("ext4", this.jdField_a_of_type_Int + "");
        agvs.a(agvm.jdField_a_of_type_JavaLangString, 3, this.b, localHashMap);
      }
      if (this.b != 0) {
        break label163;
      }
      agvn.a();
    }
    label163:
    while (this.jdField_a_of_type_Int != 404) {
      return;
    }
    agvn.a(this.jdField_a_of_type_JavaLangString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbMonitorReporter.4
 * JD-Core Version:    0.7.0.1
 */