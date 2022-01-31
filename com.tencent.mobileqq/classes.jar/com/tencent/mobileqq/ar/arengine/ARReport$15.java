package com.tencent.mobileqq.ar.arengine;

import android.os.Build;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$15
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("result", this.jdField_a_of_type_Int + "");
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    azmz.a(BaseApplication.getContext()).a("", "AREngine_openCamera", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.15
 * JD-Core Version:    0.7.0.1
 */