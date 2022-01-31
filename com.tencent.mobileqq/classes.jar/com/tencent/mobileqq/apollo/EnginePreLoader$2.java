package com.tencent.mobileqq.apollo;

import aifg;
import aihs;
import aivc;
import aiys;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(aihs paramaihs) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (aihs.a(this.this$0) != null)
    {
      aihs.a(this.this$0).a(aifg.g);
      aihs.a(this.this$0).a(aifg.f);
      String str = aivc.a(new File(aiys.s + "preload.js"));
      aihs.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */