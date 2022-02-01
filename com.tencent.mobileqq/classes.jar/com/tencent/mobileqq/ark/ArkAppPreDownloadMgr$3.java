package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ArkAppPreDownloadMgr$3
  implements Runnable
{
  ArkAppPreDownloadMgr$3(ArkAppPreDownloadMgr paramArkAppPreDownloadMgr, ArkAppPreDownloadMgr.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Object localObject = new ArkAppPreDownloadMgr.3.1(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)ArkAppPreDownloadMgr.a(this.this$0).get();
    if (localQQAppInterface != null) {}
    for (PreDownloadController localPreDownloadController = (PreDownloadController)localQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);; localPreDownloadController = null)
    {
      if (localPreDownloadController != null)
      {
        ArkAppPreDownloadMgr.a(this.this$0);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler,app=", this.a.a });
        localObject = new RunnableTask(localQQAppInterface, this.a.a, (Runnable)localObject, 10000L);
        localPreDownloadController.requestPreDownload(10080, "prd", this.a.a, ArkAppPreDownloadMgr.b(this.this$0), this.a.a, "", 1, 0, false, (AbsPreDownloadTask)localObject);
        return;
      }
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling add ark predowload to scheduler fail for predownloadCtrl null,app=", this.a.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */