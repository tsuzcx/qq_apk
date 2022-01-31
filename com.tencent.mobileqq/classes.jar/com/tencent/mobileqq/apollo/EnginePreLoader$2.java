package com.tencent.mobileqq.apollo;

import airx;
import aiuj;
import ajjc;
import ajms;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(aiuj paramaiuj) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (aiuj.a(this.this$0) != null)
    {
      aiuj.a(this.this$0).a(airx.g);
      aiuj.a(this.this$0).a(airx.f);
      String str = ajjc.a(new File(ajms.s + "preload.js"));
      aiuj.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */