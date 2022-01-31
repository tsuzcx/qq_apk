package com.tencent.mobileqq.ark;

import aleu;
import amas;
import amax;
import amay;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(aleu paramaleu) {}
  
  public void run()
  {
    amax localamax = amay.b(380).a();
    if ((localamax == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    aleu.a(this.this$0).clear();
    this.this$0.a(localamax);
    aleu.a(this.this$0);
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */