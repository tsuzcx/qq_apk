package com.tencent.mobileqq.ark;

import apop;
import aqmp;
import aqmu;
import aqmv;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(apop paramapop) {}
  
  public void run()
  {
    aqmu localaqmu = aqmv.b(380).a();
    if ((localaqmu == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    apop.a(this.this$0).clear();
    this.this$0.a(localaqmu);
    apop.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */