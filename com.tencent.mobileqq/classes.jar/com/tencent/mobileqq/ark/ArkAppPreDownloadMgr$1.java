package com.tencent.mobileqq.ark;

import aovq;
import apvk;
import apvp;
import apvq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(aovq paramaovq) {}
  
  public void run()
  {
    apvp localapvp = apvq.b(380).a();
    if ((localapvp == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    aovq.a(this.this$0).clear();
    this.this$0.a(localapvp);
    aovq.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */