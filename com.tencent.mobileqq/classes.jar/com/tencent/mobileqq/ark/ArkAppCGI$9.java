package com.tencent.mobileqq.ark;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.lang.ref.WeakReference;

class ArkAppCGI$9
  implements Runnable
{
  ArkAppCGI$9(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)ArkAppCGI.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((DownloaderFactory)((QQAppInterface)localObject).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      File localFile = new File(ArkAppCGI.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      DownloadTask localDownloadTask = new DownloadTask(this.a.jdField_a_of_type_JavaLangString, localFile);
      localDownloadTask.n = true;
      localDownloadTask.p = true;
      if (this.a.b != null) {
        localDownloadTask.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localDownloadTask.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((DownloaderInterface)localObject).a(localDownloadTask, new ArkAppCGI.9.1(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      ArkAppCGI.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */