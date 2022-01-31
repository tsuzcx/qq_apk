package com.tencent.mobileqq.activity;

import android.content.Context;
import aprk;
import bdhh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class LebaIconDownloader$1
  implements Runnable
{
  public LebaIconDownloader$1(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, bdhh parambdhh) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), this.jdField_a_of_type_JavaLangString);
      localObject = new aprk(this.jdField_a_of_type_JavaLangString, (File)localObject, 0);
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aprk)localObject, this.jdField_a_of_type_Bdhh) == 0) {
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
        QLog.i("LebaIconDownloader", 2, "download error,error code:" + bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader.1
 * JD-Core Version:    0.7.0.1
 */