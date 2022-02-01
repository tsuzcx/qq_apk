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
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      ((StringBuilder)localObject).append(",errCode=");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramDownloadTask.jdField_a_of_type_JavaLangString.indexOf("?");
    if (i == -1) {
      localObject = paramDownloadTask.jdField_a_of_type_JavaLangString;
    } else {
      localObject = paramDownloadTask.jdField_a_of_type_JavaLangString.substring(0, i);
    }
    if (AvatarPendantUtil.jdField_a_of_type_JavaLangString.equals(localObject))
    {
      if ((paramDownloadTask.jdField_a_of_type_Int == 0) && (paramDownloadTask.f == 200))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AvatarPendantUtil.b);
        ((StringBuilder)localObject).append("/icon.zip");
        localObject = ((StringBuilder)localObject).toString();
        File localFile = new File(AvatarPendantUtil.c);
        if (!DownloaderFactory.a(new File((String)localObject), localFile, false))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unzip avatarPendantMarketIcon fail: ");
            ((StringBuilder)localObject).append(paramDownloadTask.f);
            ((StringBuilder)localObject).append(", url: ");
            ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
            QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
          }
          FileUtils.deleteDirectory(AvatarPendantUtil.b);
          return;
        }
        this.a.a.sendEmptyMessage(1001);
        this.a.a.sendEmptyMessage(1000);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download avatarPendantMarketIcon fail: ");
        ((StringBuilder)localObject).append(paramDownloadTask.f);
        ((StringBuilder)localObject).append(", url: ");
        ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
        QLog.d("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
      }
      FileUtils.deleteDirectory(AvatarPendantUtil.b);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone unkonw url: ");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",errCode:");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",httpCode:");
      ((StringBuilder)localObject).append(paramDownloadTask.f);
      QLog.e("AvatarPendantActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.17
 * JD-Core Version:    0.7.0.1
 */