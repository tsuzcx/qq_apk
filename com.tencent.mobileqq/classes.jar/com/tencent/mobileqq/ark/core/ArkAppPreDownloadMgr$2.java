package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.ark.config.PreloadItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class ArkAppPreDownloadMgr$2
  implements Runnable
{
  ArkAppPreDownloadMgr$2(ArkAppPreDownloadMgr paramArkAppPreDownloadMgr, PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Object localObject = (AppRuntime)ArkAppPreDownloadMgr.a(this.this$0).get();
    if (localObject == null) {
      return;
    }
    localObject = ArkPredownloader.a((AppRuntime)localObject, this.a.a, this.a.a);
    ArkAppPreDownloadMgr.2.1 local1 = new ArkAppPreDownloadMgr.2.1(this, (ArkPredownloader.Task)localObject);
    if (localObject == null)
    {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.a });
      return;
    }
    QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
    ((ArkPredownloader.Task)localObject).a(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */