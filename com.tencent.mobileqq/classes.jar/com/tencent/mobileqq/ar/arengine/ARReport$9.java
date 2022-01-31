package com.tencent.mobileqq.ar.arengine;

import aliq;
import axrl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$9
  implements Runnable
{
  public ARReport$9(aliq paramaliq, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Boolean) {
      localHashMap.put("result", "0");
    }
    for (;;)
    {
      axrl.a(BaseApplication.getContext()).a("", "ARCloudControlinit", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("result", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.9
 * JD-Core Version:    0.7.0.1
 */