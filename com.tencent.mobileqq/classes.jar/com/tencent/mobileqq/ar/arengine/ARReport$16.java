package com.tencent.mobileqq.ar.arengine;

import amzf;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$16
  implements Runnable
{
  public ARReport$16(amzf paramamzf, long paramLong, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("result", this.jdField_a_of_type_Int + "");
    azmz.a(BaseApplication.getContext()).a("", "AREngineinitAR", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.16
 * JD-Core Version:    0.7.0.1
 */