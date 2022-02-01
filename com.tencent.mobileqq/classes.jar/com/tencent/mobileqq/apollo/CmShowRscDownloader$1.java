package com.tencent.mobileqq.apollo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class CmShowRscDownloader$1
  extends DownloadListener
{
  CmShowRscDownloader$1(String paramString1, File paramFile, AtomicInteger paramAtomicInteger1, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, CmShowRscDownloader.OnRscDownLoadListener paramOnRscDownLoadListener, CmShowRscCacheManagerImpl.IdolRscItem paramIdolRscItem, String paramString2, List paramList) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download url:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("rscContent_CmShowRscDownloader", 1, ((StringBuilder)localObject).toString());
    }
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        try
        {
          paramDownloadTask = this.jdField_a_of_type_JavaIoFile;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getParent());
          ((StringBuilder)localObject).append(File.separator);
          ZipUtils.unZipFile(paramDownloadTask, ((StringBuilder)localObject).toString());
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            break label419;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unZipFile file error resType->");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" id->");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(" error->");
          ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
          QLog.d("rscContent_CmShowRscDownloader", 2, ((StringBuilder)localObject).toString());
        }
        catch (Exception paramDownloadTask)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            break label419;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unZipFile file error resType->");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" id->");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" error->");
        ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
        QLog.d("rscContent_CmShowRscDownloader", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download file error resType->");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" id->");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("rscContent_CmShowRscDownloader", 1, ((StringBuilder)localObject).toString());
    }
    label419:
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.c.get())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmShowRscDownloader$OnRscDownLoadListener != null)
      {
        paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscCacheManagerImpl$IdolRscItem;
        if (paramDownloadTask != null) {
          paramDownloadTask = paramDownloadTask.c();
        } else {
          paramDownloadTask = "";
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloCmShowRscDownloader$OnRscDownLoadListener;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
          bool1 = false;
        }
        ((CmShowRscDownloader.OnRscDownLoadListener)localObject).a(bool1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, paramDownloadTask);
        if (QLog.isColorLevel())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("downloadApolloRes download all done uin: ");
          paramDownloadTask.append(this.jdField_b_of_type_JavaLangString);
          paramDownloadTask.append("all cnt: ");
          paramDownloadTask.append(this.c.get());
          paramDownloadTask.append(", err cnt: ");
          paramDownloadTask.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          QLog.d("rscContent_CmShowRscDownloader", 2, paramDownloadTask.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadApolloRes download uin:");
      paramDownloadTask.append(this.jdField_b_of_type_JavaLangString);
      paramDownloadTask.append(", cb cnt: ");
      paramDownloadTask.append(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      paramDownloadTask.append(", all cnt: ");
      paramDownloadTask.append(this.c.get());
      QLog.d("rscContent_CmShowRscDownloader", 2, paramDownloadTask.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowRscDownloader.1
 * JD-Core Version:    0.7.0.1
 */