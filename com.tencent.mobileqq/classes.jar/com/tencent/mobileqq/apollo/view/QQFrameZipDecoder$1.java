package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class QQFrameZipDecoder$1
  extends DownloadListener
{
  QQFrameZipDecoder$1(QQFrameZipDecoder paramQQFrameZipDecoder, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a()) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "downloadZip onDone task.getStatus()->" + paramDownloadTask.a());
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a = 2;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewQQFrameZipDecoder.a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.1
 * JD-Core Version:    0.7.0.1
 */