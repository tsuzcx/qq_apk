package com.tencent.mobileqq.ark;

import anoj;
import aolr;
import aolw;
import aolx;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(anoj paramanoj) {}
  
  public void run()
  {
    aolw localaolw = aolx.b(380).a();
    if ((localaolw == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    anoj.a(this.this$0).clear();
    this.this$0.a(localaolw);
    anoj.a(this.this$0);
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */