package com.tencent.biz.common.config;

import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class CommonConfigBase$1
  extends DownloadListener
{
  CommonConfigBase$1(CommonConfigBase paramCommonConfigBase) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a == 0) {
      paramDownloadTask = paramDownloadTask.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(paramDownloadTask);
        String str = FileUtils.b(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + paramDownloadTask);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + paramDownloadTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.config.CommonConfigBase.1
 * JD-Core Version:    0.7.0.1
 */