package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class BlessManager$3
  extends DownloadListener
{
  BlessManager$3(BlessManager paramBlessManager, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    BlessManager.b(this.c).remove(this.a);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    BlessManager.b(this.c).remove(this.a);
    if (paramDownloadTask.e() == 3)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("download finished ");
        paramDownloadTask.append(this.b);
        QLog.d("BlessManager", 2, paramDownloadTask.toString());
      }
      if ((this.b != null) && (BlessManager.d(this.c) != null) && (this.b.equals(BlessManager.d(this.c).starVideo)))
      {
        BlessManager.e(this.c);
        return;
      }
      BlessManager.c(this.c);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFile failed: ");
      localStringBuilder.append(paramDownloadTask.d);
      localStringBuilder.append(" code=");
      localStringBuilder.append(paramDownloadTask.c);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.3
 * JD-Core Version:    0.7.0.1
 */