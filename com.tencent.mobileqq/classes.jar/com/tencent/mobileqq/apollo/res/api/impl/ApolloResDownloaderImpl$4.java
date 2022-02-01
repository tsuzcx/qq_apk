package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloResDownloaderImpl$4
  extends DownloadListener
{
  ApolloResDownloaderImpl$4(ApolloResDownloaderImpl paramApolloResDownloaderImpl, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener, File paramFile) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadFaceData onDone url");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" task.getStatus():");
      localStringBuilder.append(paramDownloadTask.a());
      QLog.d("[cmshow][ApolloResDownloader]", 2, localStringBuilder.toString());
    }
    if (3 != paramDownloadTask.a())
    {
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_DOWNLOAD_FAIL);
      }
      return;
    }
    if (!this.jdField_a_of_type_JavaIoFile.exists())
    {
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_ZIP_NOT_EXISTX);
      }
      return;
    }
    try
    {
      paramDownloadTask = this.jdField_a_of_type_JavaIoFile;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getParent());
      localStringBuilder.append(File.separator);
      ZipUtils.unZipFile(paramDownloadTask, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener.a(true, 0);
      }
      return;
    }
    catch (OutOfMemoryError paramDownloadTask)
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadFaceData unZipFile file error resType->");
      localStringBuilder.append(paramDownloadTask.getMessage());
      QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener;
      if (paramDownloadTask != null)
      {
        paramDownloadTask.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_UNZIP_FAIL);
        return;
      }
    }
    catch (Exception paramDownloadTask)
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadFaceData unZipFile file error  error->");
      localStringBuilder.append(paramDownloadTask.getMessage());
      QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnFaceDataDownloadListener;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, ApolloResDownloaderImpl.FACE_ERROR_CODE_UNZIP_FAIL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.4
 * JD-Core Version:    0.7.0.1
 */