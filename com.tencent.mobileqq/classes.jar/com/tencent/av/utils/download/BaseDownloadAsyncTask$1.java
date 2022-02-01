package com.tencent.av.utils.download;

import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

class BaseDownloadAsyncTask$1
  implements Runnable
{
  BaseDownloadAsyncTask$1(BaseDownloadAsyncTask paramBaseDownloadAsyncTask, HttpClient paramHttpClient) {}
  
  public void run()
  {
    QLog.i(BaseDownloadAsyncTask.a(this.this$0), 1, "getConnectionManager().shutdown()");
    this.a.getConnectionManager().shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.download.BaseDownloadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */