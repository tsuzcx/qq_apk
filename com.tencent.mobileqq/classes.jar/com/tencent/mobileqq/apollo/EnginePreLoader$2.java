package com.tencent.mobileqq.apollo;

import akji;
import aklv;
import alao;
import alef;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(aklv paramaklv) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (aklv.a(this.this$0) != null)
    {
      aklv.a(this.this$0).a(akji.g);
      aklv.a(this.this$0).a(akji.f);
      String str = alao.a(new File(alef.s + "preload.js"));
      aklv.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */