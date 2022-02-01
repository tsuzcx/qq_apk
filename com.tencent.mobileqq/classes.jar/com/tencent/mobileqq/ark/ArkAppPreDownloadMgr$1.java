package com.tencent.mobileqq.ark;

import aqcf;
import arbu;
import arbz;
import arca;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(aqcf paramaqcf) {}
  
  public void run()
  {
    arbz localarbz = arca.b(380).a();
    if ((localarbz == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    aqcf.a(this.this$0).clear();
    this.this$0.a(localarbz);
    aqcf.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */