package com.tencent.mobileqq.apollo;

import alnr;
import alqe;
import amey;
import amip;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(alqe paramalqe) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (alqe.a(this.this$0) != null)
    {
      alqe.a(this.this$0).a(alnr.g);
      alqe.a(this.this$0).a(alnr.f);
      String str = amey.a(new File(amip.s + "preload.js"));
      alqe.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */