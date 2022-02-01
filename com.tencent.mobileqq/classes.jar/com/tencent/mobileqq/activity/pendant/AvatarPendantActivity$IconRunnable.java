package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<DownloadListener> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, DownloadListener paramDownloadListener, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramDownloadListener);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)((QQAppInterface)this.b.get()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if (localDownloaderInterface.getTask(AvatarPendantUtil.a) == null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AvatarPendantUtil.b);
        ((StringBuilder)localObject).append("/icon.zip");
        localObject = new File(((StringBuilder)localObject).toString());
        localObject = new DownloadTask(AvatarPendantUtil.a, (File)localObject);
        ((DownloadTask)localObject).p = false;
        Bundle localBundle = new Bundle();
        localDownloaderInterface.startDownload((DownloadTask)localObject, (DownloadListener)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */