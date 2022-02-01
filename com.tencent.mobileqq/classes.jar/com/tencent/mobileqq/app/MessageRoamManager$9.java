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
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.getTask(MessageRoamConstants.a) == null))
    {
      Object localObject = new File(MessageRoamConstants.b);
      DownloadTask localDownloadTask = new DownloadTask(MessageRoamConstants.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.i)
        {
          localDownloadTask.m = true;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkCloudSearchCfg file modified local time: ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", sp time: ");
            localStringBuilder.append(localDownloadTask.i);
            QLog.d("Q.roammsg.MessageRoamManager", 2, localStringBuilder.toString());
          }
        }
      }
      localDownloadTask.j = true;
      localDownloadTask.p = false;
      localObject = new Bundle();
      localDownloaderInterface.startDownload(localDownloadTask, this.this$0.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */