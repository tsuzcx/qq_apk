package com.tencent.mobileqq.apollo;

import airz;
import aiul;
import ajje;
import ajmu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(aiul paramaiul) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (aiul.a(this.this$0) != null)
    {
      aiul.a(this.this$0).a(airz.g);
      aiul.a(this.this$0).a(airz.f);
      String str = ajje.a(new File(ajmu.s + "preload.js"));
      aiul.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */