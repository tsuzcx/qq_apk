package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkPlatformConfigBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ArkAppPreDownloadMgr$1
  implements Runnable
{
  ArkAppPreDownloadMgr$1(ArkAppPreDownloadMgr paramArkAppPreDownloadMgr) {}
  
  public void run()
  {
    ArkConfBean.ArkPlatformConfigBean localArkPlatformConfigBean = ArkConfProcessor.b(380).a();
    if ((localArkPlatformConfigBean == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    ArkAppPreDownloadMgr.a(this.this$0).clear();
    this.this$0.a(localArkPlatformConfigBean);
    ArkAppPreDownloadMgr.c();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */