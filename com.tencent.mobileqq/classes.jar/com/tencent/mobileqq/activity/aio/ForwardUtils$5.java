package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

final class ForwardUtils$5
  implements Runnable
{
  ForwardUtils$5(String paramString1, int paramInt1, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    String str3 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    QLog.i("Dataline_FileAssistant", 1, "---forwardToNewDataLine--- forwardID:" + this.jdField_a_of_type_Int);
    if (FileUtils.b(this.jdField_a_of_type_JavaLangString))
    {
      String str2 = FileUtil.a(str3);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = ".jpg";
      }
      str1 = FMSettings.a().b() + str3 + str1;
      FileUtils.d(this.jdField_a_of_type_JavaLangString, str1);
      QLog.i("Dataline_FileAssistant", 1, "---forwardToNewDataLine--- sendLocalFile");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str1, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, true, 0L, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.5
 * JD-Core Version:    0.7.0.1
 */