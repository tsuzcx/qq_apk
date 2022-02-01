package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloResDownloaderImpl$4
  extends DownloadListener
{
  ApolloResDownloaderImpl$4(ApolloResDownloaderImpl paramApolloResDownloaderImpl, File paramFile) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((3 == paramDownloadTask.a()) && (this.jdField_a_of_type_JavaIoFile.exists())) {}
    try
    {
      ZipUtils.unZipFile(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception paramDownloadTask)
    {
      paramDownloadTask = paramDownloadTask;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + paramDownloadTask.getMessage());
      }
      try
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
      catch (Exception paramDownloadTask)
      {
        return;
      }
    }
    catch (OutOfMemoryError paramDownloadTask)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + paramDownloadTask.getMessage());
      }
      try
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
      catch (Exception paramDownloadTask)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        throw paramDownloadTask;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.4
 * JD-Core Version:    0.7.0.1
 */