package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class BlessManager$2
  extends DownloadListener
{
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
        paramDownloadTask.append(this.b.id);
        QLog.d("BlessManager", 2, paramDownloadTask.toString());
      }
      if (this.c.a(this.b))
      {
        this.b.broken = false;
        BlessManager.c(this.c);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadZipFile failed: ");
        localStringBuilder.append(paramDownloadTask.d);
        localStringBuilder.append(" code=");
        localStringBuilder.append(paramDownloadTask.c);
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      this.c.a(this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.2
 * JD-Core Version:    0.7.0.1
 */