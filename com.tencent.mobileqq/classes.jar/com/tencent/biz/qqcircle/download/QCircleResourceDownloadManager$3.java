package com.tencent.biz.qqcircle.download;

import bdms;
import com.tencent.qphone.base.util.QLog;
import twe;
import twg;
import twi;

public class QCircleResourceDownloadManager$3
  implements Runnable
{
  public void run()
  {
    if (bdms.a() == null)
    {
      QLog.i(twe.jdField_a_of_type_JavaLangString, 1, "downloadOrUpdateFile error, SdCardUtil.getSdCardDirectory() == null");
      if (this.jdField_a_of_type_Twi != null) {
        this.jdField_a_of_type_Twi.a(false, "");
      }
    }
    if (this.jdField_a_of_type_Twi != null) {
      twe.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twi);
    }
    this.this$0.a(this.jdField_a_of_type_JavaLangString, new twg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */