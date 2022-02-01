package com.tencent.mobileqq.apollo;

import amsx;
import amvk;
import anke;
import annv;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(amvk paramamvk) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (amvk.a(this.this$0) != null)
    {
      amvk.a(this.this$0).a(amsx.g);
      amvk.a(this.this$0).a(amsx.f);
      String str = anke.a(new File(annv.s + "preload.js"));
      amvk.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */