package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class ApolloResDownloaderImpl$2
  extends DownloadListener
{
  ApolloResDownloaderImpl$2(File paramFile, IApolloManagerService paramIApolloManagerService, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList paramOnApolloDownLoadListenerForTaskList, String paramString, List paramList) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        ZipUtils.unZipFile(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
        ApolloResDownloaderImpl.saveResTimestamp(this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.c.get()) {
          break label413;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl$OnApolloDownLoadListenerForTaskList != null)
        {
          paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl$OnApolloDownLoadListenerForTaskList;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
            bool = false;
          }
          paramDownloadTask.a(bool, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_a_of_type_JavaLangString + "all cnt: " + this.c.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
        }
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
      catch (Exception paramDownloadTask)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + paramDownloadTask.getMessage());
        continue;
      }
      catch (OutOfMemoryError paramDownloadTask)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + paramDownloadTask.getMessage());
        continue;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      QLog.d("ApolloResDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + paramDownloadTask.a());
      continue;
      label413:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.jdField_a_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.c.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */