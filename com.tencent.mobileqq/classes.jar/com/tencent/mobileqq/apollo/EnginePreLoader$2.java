package com.tencent.mobileqq.apollo;

import aknx;
import akqk;
import alfd;
import aliu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EnginePreLoader$2
  implements Runnable
{
  public EnginePreLoader$2(akqk paramakqk) {}
  
  public void run()
  {
    QLog.i("Apollo_EnginePreLoader", 1, "sava exePreloadJsAsync start");
    long l = System.currentTimeMillis();
    if (akqk.a(this.this$0) != null)
    {
      akqk.a(this.this$0).a(aknx.g);
      akqk.a(this.this$0).a(aknx.f);
      String str = alfd.a(new File(aliu.s + "preload.js"));
      akqk.a(this.this$0).a(str);
    }
    QLog.i("Apollo_EnginePreLoader", 1, "inner sava use time:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.EnginePreLoader.2
 * JD-Core Version:    0.7.0.1
 */