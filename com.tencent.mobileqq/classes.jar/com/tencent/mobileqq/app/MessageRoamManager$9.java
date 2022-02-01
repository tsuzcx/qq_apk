package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class MessageRoamManager$9
  implements Runnable
{
  MessageRoamManager$9(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.this$0.b.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.getTask(MessageRoamConstants.a) == null))
    {
      Object localObject = new File(MessageRoamConstants.b);
      DownloadTask localDownloadTask = new DownloadTask(MessageRoamConstants.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.I = this.this$0.b.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.I)
        {
          localDownloadTask.G = true;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkCloudSearchCfg file modified local time: ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", sp time: ");
            localStringBuilder.append(localDownloadTask.I);
            QLog.d("Q.roammsg.MessageRoamManager", 2, localStringBuilder.toString());
          }
        }
      }
      localDownloadTask.D = true;
      localDownloadTask.N = false;
      localObject = new Bundle();
      localDownloaderInterface.startDownload(localDownloadTask, this.this$0.y, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */