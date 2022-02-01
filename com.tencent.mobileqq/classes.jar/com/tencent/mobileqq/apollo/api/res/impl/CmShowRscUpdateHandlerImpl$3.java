package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CmShowRscUpdateHandlerImpl$3
  extends DownloadListener
{
  CmShowRscUpdateHandlerImpl$3(CmShowRscUpdateHandlerImpl paramCmShowRscUpdateHandlerImpl, File paramFile, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch task.getStatus:" + paramDownloadTask.a());
    }
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.e();
        paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.c();
        if (BspatchUtil.a(str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramDownloadTask))
        {
          try
          {
            str = MD5Utils.encodeFileHexStr(paramDownloadTask);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadZipAndPatch onDone dstMd5:" + str + " result.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.d);
            }
            if (CmShowRscUpdateHandlerImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult, str))
            {
              if (CmShowRscUpdateHandlerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult))
              {
                ZipUtils.unZipFile(new File(paramDownloadTask), this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile ok file path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " dstpath:" + paramDownloadTask);
                }
              }
              for (;;)
              {
                CmShowRscUpdateHandlerImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
                return;
                boolean bool = FileUtils.d(paramDownloadTask, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.b() + this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_JavaLangString);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch no need unzip copy:" + bool);
              }
            }
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + paramDownloadTask.getMessage());
          }
          catch (Exception paramDownloadTask)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch unZipFile file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + paramDownloadTask.getMessage());
            return;
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
            return;
          }
          catch (OutOfMemoryError paramDownloadTask)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
        else
        {
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
        }
      }
      else
      {
        CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch patchFile no exist path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + paramDownloadTask.a());
      }
    }
    else {
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadZipAndPatch  file error path->" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " task.getStatus()->" + paramDownloadTask.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.3
 * JD-Core Version:    0.7.0.1
 */