package com.tencent.mobileqq.ar.arengine;

import akue;
import awrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$5
  implements Runnable
{
  public ARReport$5(akue paramakue, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loadingtime", String.valueOf(this.a));
    awrn.a(BaseApplication.getContext()).a("", "AndroidactARWebView", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.5
 * JD-Core Version:    0.7.0.1
 */