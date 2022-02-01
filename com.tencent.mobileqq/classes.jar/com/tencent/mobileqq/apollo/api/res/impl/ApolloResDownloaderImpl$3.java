package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloResDownloaderImpl$3
  extends DownloadListener
{
  ApolloResDownloaderImpl$3(ApolloResDownloaderImpl paramApolloResDownloaderImpl, File paramFile, IApolloManagerService paramIApolloManagerService, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, String paramString, int paramInt3, int[] paramArrayOfInt, int paramInt4) {}
  
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
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
          break label421;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener != null)
        {
          paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResDownloader$OnApolloDownLoadListener;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
            bool = false;
          }
          paramDownloadTask.a(bool, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.d);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_a_of_type_JavaLangString + "all cnt: " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
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
      label421:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.jdField_a_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.3
 * JD-Core Version:    0.7.0.1
 */