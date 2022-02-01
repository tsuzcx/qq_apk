package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloResDownloaderImpl$5
  extends DownloadListener
{
  ApolloResDownloaderImpl$5(ApolloResDownloaderImpl paramApolloResDownloaderImpl, String paramString, File paramFile, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData onDone url" + this.jdField_a_of_type_JavaLangString + " task.getStatus():" + paramDownloadTask.a());
    }
    if (3 == paramDownloadTask.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener == null)
    {
      do
      {
        try
        {
          ZipUtils.unZipFile(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener.a(true, 0);
          }
          return;
        }
        catch (Exception paramDownloadTask)
        {
          do
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error  error->" + paramDownloadTask.getMessage());
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener == null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_UNZIP_FAIL);
          return;
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          do
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "checkDownloadFaceData unZipFile file error resType->" + paramDownloadTask.getMessage());
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener == null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_UNZIP_FAIL);
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_ZIP_NOT_EXISTX);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnFaceDataDownloadListener.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_DOWNLOAD_FAIL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.5
 * JD-Core Version:    0.7.0.1
 */