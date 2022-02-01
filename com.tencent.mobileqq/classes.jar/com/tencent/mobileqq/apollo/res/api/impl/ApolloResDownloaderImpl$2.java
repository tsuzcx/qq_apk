package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloResDownloaderImpl$2
  extends DownloadListener
{
  ApolloResDownloaderImpl$2(ApolloResDownloaderImpl paramApolloResDownloaderImpl, File paramFile, IApolloManagerService paramIApolloManagerService, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, String paramString, int paramInt3, int[] paramArrayOfInt, int paramInt4) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    StringBuilder localStringBuilder;
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        try
        {
          paramDownloadTask = this.jdField_a_of_type_JavaIoFile;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getParent());
          localStringBuilder.append(File.separator);
          ZipUtils.unZipFile(paramDownloadTask, localStringBuilder.toString());
          ApolloResDownloaderImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unZipFile file error resType->");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append(" id->");
          localStringBuilder.append(this.jdField_b_of_type_Int);
          localStringBuilder.append(" error->");
          localStringBuilder.append(paramDownloadTask.getMessage());
          QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
        }
        catch (Exception paramDownloadTask)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            break label345;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unZipFile file error resType->");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" id->");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" error->");
        localStringBuilder.append(paramDownloadTask.getMessage());
        QLog.d("[cmshow][ApolloResDownloader]", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_JavaIoFile.getParentFile().delete();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download file error resType->");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" id->");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" task.getStatus()->");
      localStringBuilder.append(paramDownloadTask.a());
      localStringBuilder.append(" task.errCode=");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.d("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
    }
    label345:
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResDownloader$OnApolloDownLoadListener;
      if (paramDownloadTask != null)
      {
        boolean bool;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
          bool = false;
        } else {
          bool = true;
        }
        paramDownloadTask.a(bool, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.d);
        if (QLog.isColorLevel())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("downloadApolloRes download all done uin: ");
          paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
          paramDownloadTask.append("all cnt: ");
          paramDownloadTask.append(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          paramDownloadTask.append(", err cnt: ");
          paramDownloadTask.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          QLog.d("[cmshow][ApolloResDownloader]", 2, paramDownloadTask.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadApolloRes download uin:");
      paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
      paramDownloadTask.append(", cb cnt: ");
      paramDownloadTask.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      paramDownloadTask.append(", all cnt: ");
      paramDownloadTask.append(this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      QLog.d("[cmshow][ApolloResDownloader]", 2, paramDownloadTask.toString());
    }
    this.jdField_a_of_type_JavaIoFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */