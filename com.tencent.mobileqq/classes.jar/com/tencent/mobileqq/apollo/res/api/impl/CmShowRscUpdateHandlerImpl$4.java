package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CmShowRscUpdateHandlerImpl$4
  extends DownloadListener
{
  CmShowRscUpdateHandlerImpl$4(CmShowRscUpdateHandlerImpl paramCmShowRscUpdateHandlerImpl, File paramFile, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadAllZip task.getStatus:");
      localStringBuilder.append(paramDownloadTask.a());
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
    }
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          paramDownloadTask = MD5Utils.encodeFileHexStr(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" downloadAllZip onDone dstMd5:");
            localStringBuilder.append(paramDownloadTask);
            localStringBuilder.append(" result.mMd5:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.d);
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
          }
          if (CmShowRscUpdateHandlerImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult, paramDownloadTask))
          {
            if (CmShowRscUpdateHandlerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult))
            {
              paramDownloadTask = this.jdField_a_of_type_JavaIoFile;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getParent());
              localStringBuilder.append(File.separator);
              ZipUtils.unZipFile(paramDownloadTask, localStringBuilder.toString());
              if (QLog.isColorLevel())
              {
                paramDownloadTask = new StringBuilder();
                paramDownloadTask.append("downloadAllZip unZipFile ok file path->");
                paramDownloadTask.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, paramDownloadTask.toString());
              }
            }
            else
            {
              paramDownloadTask = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.b());
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_JavaLangString);
              boolean bool = FileUtils.copyFile(paramDownloadTask, localStringBuilder.toString());
              paramDownloadTask = new StringBuilder();
              paramDownloadTask.append("downloadAllZip no need unzip copy:");
              paramDownloadTask.append(bool);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
            }
            CmShowRscUpdateHandlerImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
            return;
          }
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("downloadAllZip unZipFile file error path->");
            localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
            localStringBuilder.append(paramDownloadTask.getMessage());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
        catch (Exception paramDownloadTask)
        {
          CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadAllZip unZipFile file error path->");
          localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          localStringBuilder.append(paramDownloadTask.getMessage());
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
          return;
        }
      }
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("downloadAllZip  file error path- no exist:");
      paramDownloadTask.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
      CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadAllZip  file error path->");
    localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    localStringBuilder.append(" task.getStatus()->");
    localStringBuilder.append(paramDownloadTask.a());
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */