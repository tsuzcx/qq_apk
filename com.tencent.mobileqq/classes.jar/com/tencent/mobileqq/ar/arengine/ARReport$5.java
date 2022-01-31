package com.tencent.mobileqq.ar.arengine;

import amzf;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$5
  implements Runnable
{
  public ARReport$5(amzf paramamzf, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loadingtime", String.valueOf(this.a));
    azmz.a(BaseApplication.getContext()).a("", "AndroidactARWebView", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.5
 * JD-Core Version:    0.7.0.1
 */