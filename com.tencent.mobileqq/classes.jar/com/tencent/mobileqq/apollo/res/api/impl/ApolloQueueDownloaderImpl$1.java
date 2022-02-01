package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class ApolloQueueDownloaderImpl$1
  implements Runnable
{
  ApolloQueueDownloaderImpl$1(ApolloQueueDownloaderImpl paramApolloQueueDownloaderImpl, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doTask | run() downloadLimitCount=");
      ((StringBuilder)localObject).append(this.this$0.downloadLimitCount.get());
      ((StringBuilder)localObject).append(",task=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.o) && (DownloaderFactory.a(this.a.b)))
    {
      localObject = this.a;
      ((DownloadTask)localObject).c = -101;
      ((DownloadTask)localObject).a(-1);
      this.a.n();
      this.this$0.removeTask(this.a);
      this.this$0.downloadLimitCount.addAndGet(-1);
      this.this$0.doTask();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doTask | run() task is limit of failTime, task=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int i = DownloaderFactory.a(this.a, (AppRuntime)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doTask | run() download task result=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",task=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("[cmshow]ApolloQueue_Downloader", 2, ((StringBuilder)localObject).toString());
    }
    this.this$0.removeTask(this.a);
    this.this$0.downloadLimitCount.addAndGet(-1);
    this.this$0.doTask();
  }
  
  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((this.a.f != null) && (this.a.f.size() != 0)) {
        str = (String)this.a.f.get(0);
      } else {
        str = this.a.b;
      }
      localStringBuilder.append("[cmshow]ApolloQueue_Downloader");
      localStringBuilder.append(" current task:");
      localStringBuilder.append(str);
      localStringBuilder.append(",downloadQueue size:");
      int i;
      if (ApolloQueueDownloaderImpl.access$000(this.this$0) == null) {
        i = 0;
      } else {
        i = ApolloQueueDownloaderImpl.access$000(this.this$0).size();
      }
      localStringBuilder.append(i);
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloQueue_Downloader", 1, localException, new Object[0]);
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloQueueDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */