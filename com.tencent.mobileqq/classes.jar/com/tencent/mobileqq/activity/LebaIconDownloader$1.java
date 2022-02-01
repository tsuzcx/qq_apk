package com.tencent.mobileqq.activity;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class LebaIconDownloader$1
  implements Runnable
{
  LebaIconDownloader$1(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), this.jdField_a_of_type_JavaLangString);
      String str = this.jdField_a_of_type_JavaLangString;
      boolean bool = false;
      localObject = new DownloadInfo(str, (File)localObject, 0);
      if (HttpDownloadUtil.downloadData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$HttpDownloadListener) == 0) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LebaIconDownloader", 2, "download ok");
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download error,error code:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("LebaIconDownloader", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaIconDownloader", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader.1
 * JD-Core Version:    0.7.0.1
 */