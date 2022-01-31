package com.tencent.biz.qqcircle.download;

import bdms;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;
import twe;
import twi;

public class QCircleResourceDownloadManager$1
  implements Runnable
{
  public QCircleResourceDownloadManager$1(twe paramtwe, String paramString, twi paramtwi) {}
  
  public void run()
  {
    String str = this.this$0.a(this.jdField_a_of_type_JavaLangString);
    File localFile = new File(str);
    if (bdms.a() == null)
    {
      QLog.i(twe.jdField_a_of_type_JavaLangString, 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.jdField_a_of_type_Twi != null) {
        this.jdField_a_of_type_Twi.a(false, "");
      }
    }
    if (localFile.exists())
    {
      QLog.i(twe.jdField_a_of_type_JavaLangString, 1, "getFile success, the file is exist path:" + str);
      if (this.jdField_a_of_type_Twi != null) {
        this.jdField_a_of_type_Twi.a(true, str);
      }
      return;
    }
    if (this.jdField_a_of_type_Twi != null) {
      twe.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twi);
    }
    if (twe.a(this.this$0).contains(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i(twe.jdField_a_of_type_JavaLangString, 1, "getFile ..., file is downloading");
      return;
    }
    QLog.i(twe.jdField_a_of_type_JavaLangString, 1, "getFile ..., start download");
    twe.a(this.this$0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */