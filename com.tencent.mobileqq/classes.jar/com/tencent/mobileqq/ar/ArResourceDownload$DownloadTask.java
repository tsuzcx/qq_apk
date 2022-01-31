package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class ArResourceDownload$DownloadTask
  extends AbsPreDownloadTask
{
  ArResourceDownload.DownloadInfo jdField_a_of_type_ComTencentMobileqqArArResourceDownload$DownloadInfo;
  ArResourceDownload jdField_a_of_type_ComTencentMobileqqArArResourceDownload;
  
  public ArResourceDownload$DownloadTask(QQAppInterface paramQQAppInterface, ArResourceDownload.DownloadInfo paramDownloadInfo, ArResourceDownload paramArResourceDownload)
  {
    super(paramQQAppInterface, paramDownloadInfo.b);
    this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload$DownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload = paramArResourceDownload;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
    }
    ArResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload, this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload$DownloadInfo);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload$DownloadInfo + ", mDownloader=" + this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload.DownloadTask
 * JD-Core Version:    0.7.0.1
 */