package com.tencent.mobileqq.apollo.res.api.impl;

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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZipAndPatch task.getStatus:");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.e();
        paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.c();
        if (BspatchUtil.a((String)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramDownloadTask))
        {
          try
          {
            localObject = MD5Utils.encodeFileHexStr(paramDownloadTask);
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" downloadZipAndPatch onDone dstMd5:");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" result.mMd5:");
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.d);
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
            }
            if (CmShowRscUpdateHandlerImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult, (String)localObject))
            {
              if (CmShowRscUpdateHandlerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult))
              {
                localObject = new File(paramDownloadTask);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getParent());
                localStringBuilder.append(File.separator);
                ZipUtils.unZipFile((File)localObject, localStringBuilder.toString());
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile ok file path->");
                  ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
                  ((StringBuilder)localObject).append(" dstpath:");
                  ((StringBuilder)localObject).append(paramDownloadTask);
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
                }
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.b());
                ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_JavaLangString);
                boolean bool = FileUtils.copyFile(paramDownloadTask, ((StringBuilder)localObject).toString());
                paramDownloadTask = new StringBuilder();
                paramDownloadTask.append("downloadZipAndPatch no need unzip copy:");
                paramDownloadTask.append(bool);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
              }
              CmShowRscUpdateHandlerImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
              return;
            }
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
            return;
          }
          catch (OutOfMemoryError paramDownloadTask)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile file error path->");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
            ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
            return;
          }
          catch (Exception paramDownloadTask)
          {
            this.jdField_a_of_type_JavaIoFile.delete();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile file error path->");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
            ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
            return;
          }
        }
        else
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("downloadZipAndPatch patchFile error path->");
          paramDownloadTask.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
          CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
        }
      }
      else
      {
        CmShowRscUpdateHandlerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplCmShowRscUpdateHandlerImpl$ContentUpdateCheckResult);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadZipAndPatch patchFile no exist path->");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        ((StringBuilder)localObject).append(" task.getStatus()->");
        ((StringBuilder)localObject).append(paramDownloadTask.a());
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZipAndPatch  file error path->");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      ((StringBuilder)localObject).append(" task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.3
 * JD-Core Version:    0.7.0.1
 */