package com.tencent.mobileqq.apollo;

import amhd;
import amjq;
import amyk;
import ancb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(amjq paramamjq) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (amjq.a(this.this$0) != null)
    {
      amjq.a(this.this$0).a(amhd.g);
      amjq.a(this.this$0).a(amhd.f);
      String str = amyk.a(new File(ancb.s + "preload.js"));
      amjq.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */