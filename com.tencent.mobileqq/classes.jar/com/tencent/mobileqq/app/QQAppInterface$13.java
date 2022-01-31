package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QQAppInterface$13
  implements Runnable
{
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(this.this$0, MsfSdkUtils.insertMtype("lingyin", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "-->SpecialSound download result:" + bool);
    }
    File localFile;
    if (bool)
    {
      localFile = new File(QQAppInterface.d(this.this$0).getApplicationContext().getFilesDir(), this.jdField_a_of_type_JavaLangString);
      if (localFile == null) {
        break label105;
      }
    }
    label105:
    for (long l = localFile.length();; l = 0L)
    {
      QQAppInterface.a(this.this$0).a(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.13
 * JD-Core Version:    0.7.0.1
 */