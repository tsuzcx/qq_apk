package com.tencent.mobileqq.ark;

import apyu;
import aqyn;
import aqys;
import aqyt;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ArkAppPreDownloadMgr$1
  implements Runnable
{
  public ArkAppPreDownloadMgr$1(apyu paramapyu) {}
  
  public void run()
  {
    aqys localaqys = aqyt.b(380).a();
    if ((localaqys == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    apyu.a(this.this$0).clear();
    this.this$0.a(localaqys);
    apyu.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */