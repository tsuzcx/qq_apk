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
    Object localObject;
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = paramDownloadTask.a().getString("file_path");
      try
      {
        localObject = new File(paramDownloadTask);
        String str = FileUtils.readFileToString((File)localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDone() content =  ");
          localStringBuilder.append(str);
          localStringBuilder.append(", filePath = ");
          localStringBuilder.append(paramDownloadTask);
          QLog.d("CommonConfigBase", 2, localStringBuilder.toString());
        }
        ((File)localObject).delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(paramDownloadTask));
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError(), errorCode = ");
      ((StringBuilder)localObject).append(paramDownloadTask.a);
      QLog.d("CommonConfigBase", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.config.CommonConfigBase.1
 * JD-Core Version:    0.7.0.1
 */