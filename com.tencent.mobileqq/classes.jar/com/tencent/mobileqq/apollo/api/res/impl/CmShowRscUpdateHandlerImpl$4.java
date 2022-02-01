package com.tencent.mobileqq.apollo.api.res.impl;

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
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + paramDownloadTask.a());
    }
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          paramDownloadTask = MD5Utils.encodeFileHexStr(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + paramDownloadTask + " result.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.d);
          }
          if (CmShowRscUpdateHandlerImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult, paramDownloadTask))
          {
            if (CmShowRscUpdateHandlerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult))
            {
              ZipUtils.unZipFile(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
              }
            }
            for (;;)
            {
              CmShowRscUpdateHandlerImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
              return;
              boolean bool = FileUtils.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.b() + this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_JavaLangString);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        }
        catch (Exception paramDownloadTask)
        {
          CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
          this.jdField_a_of_type_JavaIoFile.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + paramDownloadTask.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
          return;
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + paramDownloadTask.getMessage());
          }
          this.jdField_a_of_type_JavaIoFile.delete();
          return;
        }
      }
      CmShowRscUpdateHandlerImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + paramDownloadTask.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */