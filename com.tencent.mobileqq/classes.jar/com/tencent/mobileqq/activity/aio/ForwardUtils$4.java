package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

final class ForwardUtils$4
  implements FMDialogUtil.FMDialogInterface
{
  ForwardUtils$4(ArrayList paramArrayList, Activity paramActivity, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, String paramString2) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    String str1;
    String str2;
    if (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      str1 = "";
      if (localUri != null) {
        str1 = new UriParserPathHelper(this.jdField_a_of_type_AndroidAppActivity, false, null).a(localUri);
      }
      if (TextUtils.isEmpty(str1))
      {
        str2 = "localPath = null. model:" + Build.MANUFACTURER + "-" + Build.MODEL;
        if (localUri == null) {
          break label201;
        }
        str2 = str2 + " uri:" + localUri.toString();
      }
    }
    label201:
    for (;;)
    {
      QLog.e("ForwardUtils<FileAssistant>", 1, str2);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str1, this.jdField_a_of_type_JavaLangString, 0L, this.jdField_b_of_type_Int);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, 0L, this.jdField_b_of_type_Int);
      break;
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.4
 * JD-Core Version:    0.7.0.1
 */