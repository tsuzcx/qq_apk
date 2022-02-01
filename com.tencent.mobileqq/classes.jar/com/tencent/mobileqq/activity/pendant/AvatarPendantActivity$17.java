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
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.jdField_a_of_type_Int);
    }
    int i = paramDownloadTask.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (!AvatarPendantUtil.jdField_a_of_type_JavaLangString.equals(str)) {
        break label297;
      }
      if ((paramDownloadTask.jdField_a_of_type_Int != 0) || (paramDownloadTask.f != 200)) {
        break label244;
      }
      str = AvatarPendantUtil.b + "/icon.zip";
      localFile = new File(AvatarPendantUtil.c);
      if (DownloaderFactory.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + paramDownloadTask.f + ", url: " + paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(AvatarPendantUtil.b);
    }
    label215:
    label244:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = paramDownloadTask.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      this.a.a.sendEmptyMessage(1001);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + paramDownloadTask.f + ", url: " + paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(AvatarPendantUtil.b);
      return;
    }
    label297:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + paramDownloadTask.jdField_a_of_type_JavaLangString + ",errCode:" + paramDownloadTask.jdField_a_of_type_Int + ",httpCode:" + paramDownloadTask.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.17
 * JD-Core Version:    0.7.0.1
 */