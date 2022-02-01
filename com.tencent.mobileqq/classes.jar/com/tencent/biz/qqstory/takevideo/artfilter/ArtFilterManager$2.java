package com.tencent.biz.qqstory.takevideo.artfilter;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ArtFilterManager$2
  extends DownloadListener
{
  ArtFilterManager$2(ArtFilterManager paramArtFilterManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    long l2 = -1L;
    super.onDone(paramDownloadTask);
    Object localObject2 = paramDownloadTask.a();
    if (localObject2 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "download bundle null");
      }
    }
    String str;
    Object localObject1;
    do
    {
      return;
      str = ((Bundle)localObject2).getString("url");
      localObject1 = ((Bundle)localObject2).getString("md5");
      localObject2 = ((Bundle)localObject2).getString("path");
      if ((str != null) && (localObject1 != null) && (localObject2 != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArtFilterManager", 2, "download bundle parms null");
    return;
    if (paramDownloadTask.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[onDone] download finished " + str);
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        this.a.a((String)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = (PreDownloadController)ArtFilterManager.a(this.a).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      localObject2 = new File((String)localObject2);
      long l1 = l2;
      if (paramDownloadTask.a == 0)
      {
        l1 = l2;
        if (((File)localObject2).exists()) {
          l1 = ((File)localObject2).length();
        }
      }
      ((PreDownloadController)localObject1).preDownloadSuccess(str, l1);
      return;
      if (((String)localObject1).equalsIgnoreCase(this.a.a((String)localObject2)))
      {
        this.a.a((String)localObject2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[onDone] checkMd5 failed: " + (String)localObject2);
        }
        FileUtils.e((String)localObject2);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[onDone] downloadFile failed: " + paramDownloadTask.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager.2
 * JD-Core Version:    0.7.0.1
 */