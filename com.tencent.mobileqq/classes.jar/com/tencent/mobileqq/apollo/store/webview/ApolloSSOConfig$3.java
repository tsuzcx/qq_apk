package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class ApolloSSOConfig$3
  implements Runnable
{
  ApolloSSOConfig$3(AppRuntime paramAppRuntime, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    Object localObject = ApolloResDownloaderUtil.a(this.a);
    boolean bool;
    if (localObject != null)
    {
      DownloadTask localDownloadTask = this.b;
      ((DownloaderInterface)localObject).startDownload(localDownloadTask, localDownloadTask.a(), null);
      bool = false;
    }
    else
    {
      DownloaderFactory.a(this.b, null);
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUpdateApolloWebViewConfig async:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.3
 * JD-Core Version:    0.7.0.1
 */