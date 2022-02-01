package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AvatarPendantActivity$17
  extends DownloadListener
{
  AvatarPendantActivity$17(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download onDone status=");
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      ((StringBuilder)localObject).append(",errCode=");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramDownloadTask.b.indexOf("?");
    if (i == -1) {
      localObject = paramDownloadTask.b;
    } else {
      localObject = paramDownloadTask.b.substring(0, i);
    }
    if (AvatarPendantUtil.c.equals(localObject))
    {
      if ((paramDownloadTask.c == 0) && (paramDownloadTask.H == 200))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AvatarPendantUtil.d);
        ((StringBuilder)localObject).append("/icon.zip");
        localObject = ((StringBuilder)localObject).toString();
        File localFile = new File(AvatarPendantUtil.e);
        if (!DownloaderFactory.a(new File((String)localObject), localFile, false))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unzip avatarPendantMarketIcon fail: ");
            ((StringBuilder)localObject).append(paramDownloadTask.H);
            ((StringBuilder)localObject).append(", url: ");
            ((StringBuilder)localObject).append(paramDownloadTask.b);
            QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
          }
          FileUtils.deleteDirectory(AvatarPendantUtil.d);
          return;
        }
        this.a.M.sendEmptyMessage(1001);
        this.a.M.sendEmptyMessage(1000);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download avatarPendantMarketIcon fail: ");
        ((StringBuilder)localObject).append(paramDownloadTask.H);
        ((StringBuilder)localObject).append(", url: ");
        ((StringBuilder)localObject).append(paramDownloadTask.b);
        QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
      }
      FileUtils.deleteDirectory(AvatarPendantUtil.d);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone unkonw url: ");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      ((StringBuilder)localObject).append(",errCode:");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      ((StringBuilder)localObject).append(",httpCode:");
      ((StringBuilder)localObject).append(paramDownloadTask.H);
      QLog.e("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.17
 * JD-Core Version:    0.7.0.1
 */