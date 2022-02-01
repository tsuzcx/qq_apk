package com.tencent.mobileqq.apollo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class ApolloQueueDownloader$1
  implements Runnable
{
  ApolloQueueDownloader$1(ApolloQueueDownloader paramApolloQueueDownloader, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "doTask | run() downloadLimitCount=" + this.this$0.a.get() + ",task=" + this.a);
    }
    if ((this.a.c) && (DownloaderFactory.a(this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.jdField_a_of_type_Int = -101;
      this.a.a(-1);
      this.a.f();
      this.this$0.a(this.a);
      this.this$0.a.addAndGet(-1);
      this.this$0.a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloQueue_Downloader", 2, "doTask | run() task is limit of failTime, task=" + this.a);
      }
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = DownloaderFactory.a(this.a, localAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloQueue_Downloader", 2, "doTask | run() download task result=" + i + ",task=" + this.a);
    }
    this.this$0.a(this.a);
    this.this$0.a.addAndGet(-1);
    this.this$0.a();
  }
  
  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject;
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        localObject = this.a.jdField_a_of_type_JavaLangString;
        localObject = localStringBuilder.append("ApolloQueue_Downloader").append(" current task:").append((String)localObject).append(",downloadQueue size:");
        if (ApolloQueueDownloader.a(this.this$0) != null) {
          break label105;
        }
      }
      label105:
      for (int i = 0;; i = ApolloQueueDownloader.a(this.this$0).size())
      {
        ((StringBuilder)localObject).append(i);
        return localStringBuilder.toString();
        localObject = (String)this.a.jdField_a_of_type_JavaUtilList.get(0);
        break;
      }
      return super.toString();
    }
    catch (Exception localException)
    {
      QLog.e("ApolloQueue_Downloader", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloQueueDownloader.1
 * JD-Core Version:    0.7.0.1
 */