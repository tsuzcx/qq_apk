package com.tencent.mobileqq.ar.arengine;

import ando;
import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$6
  implements Runnable
{
  public ARReport$6(ando paramando, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.a));
    azri.a(BaseApplication.getContext()).a("", "ARMarkerResourceManagerInt", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.6
 * JD-Core Version:    0.7.0.1
 */