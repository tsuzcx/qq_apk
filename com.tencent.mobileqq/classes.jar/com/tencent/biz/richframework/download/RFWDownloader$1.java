package com.tencent.biz.richframework.download;

import bgru;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;
import zwe;
import zwi;

public class RFWDownloader$1
  implements Runnable
{
  public RFWDownloader$1(zwe paramzwe, String paramString, zwi paramzwi) {}
  
  public void run()
  {
    String str = this.this$0.b(this.jdField_a_of_type_JavaLangString);
    File localFile = new File(str);
    if (bgru.a() == null)
    {
      QLog.i("RFWDownloader", 1, "getFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.jdField_a_of_type_Zwi != null) {
        this.jdField_a_of_type_Zwi.a(false, "");
      }
    }
    if (localFile.exists())
    {
      QLog.i("RFWDownloader", 1, "getFile success, the file is exist path:" + str);
      if (this.jdField_a_of_type_Zwi != null) {
        this.jdField_a_of_type_Zwi.a(true, str);
      }
      return;
    }
    if (this.jdField_a_of_type_Zwi != null) {
      zwe.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zwi);
    }
    if (zwe.a(this.this$0).contains(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("RFWDownloader", 1, "getFile ..., file is downloading");
      return;
    }
    QLog.i("RFWDownloader", 1, "getFile ..., start download");
    zwe.a(this.this$0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.1
 * JD-Core Version:    0.7.0.1
 */