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
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (3 == paramDownloadTask.e())
    {
      if (this.a.exists())
      {
        localObject = this.b.e();
        paramDownloadTask = this.b.c();
        if (BspatchUtil.a((String)localObject, this.a.getAbsolutePath(), paramDownloadTask))
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
              localStringBuilder.append(this.b.k);
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, localStringBuilder.toString());
            }
            if (CmShowRscUpdateHandlerImpl.access$400(this.b, (String)localObject))
            {
              if (CmShowRscUpdateHandlerImpl.access$500(this.b))
              {
                localObject = new File(paramDownloadTask);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(this.a.getParent());
                localStringBuilder.append(File.separator);
                ZipUtils.unZipFile((File)localObject, localStringBuilder.toString());
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile ok file path->");
                  ((StringBuilder)localObject).append(this.a.getAbsolutePath());
                  ((StringBuilder)localObject).append(" dstpath:");
                  ((StringBuilder)localObject).append(paramDownloadTask);
                  QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
                }
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.b.b());
                ((StringBuilder)localObject).append(this.b.l);
                boolean bool = FileUtils.copyFile(paramDownloadTask, ((StringBuilder)localObject).toString());
                paramDownloadTask = new StringBuilder();
                paramDownloadTask.append("downloadZipAndPatch no need unzip copy:");
                paramDownloadTask.append(bool);
                QLog.i("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
              }
              CmShowRscUpdateHandlerImpl.access$600(this.c, this.b.p, this.b);
              return;
            }
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
            CmShowRscUpdateHandlerImpl.access$700(this.c, this.b);
            return;
          }
          catch (OutOfMemoryError paramDownloadTask)
          {
            this.a.delete();
            if (!QLog.isColorLevel()) {
              return;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile file error path->");
            ((StringBuilder)localObject).append(this.a.getAbsolutePath());
            ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
            return;
          }
          catch (Exception paramDownloadTask)
          {
            this.a.delete();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadZipAndPatch unZipFile file error path->");
            ((StringBuilder)localObject).append(this.a.getAbsolutePath());
            ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
            return;
          }
        }
        else
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("downloadZipAndPatch patchFile error path->");
          paramDownloadTask.append(this.a.getAbsolutePath());
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, paramDownloadTask.toString());
          CmShowRscUpdateHandlerImpl.access$700(this.c, this.b);
        }
      }
      else
      {
        CmShowRscUpdateHandlerImpl.access$700(this.c, this.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadZipAndPatch patchFile no exist path->");
        ((StringBuilder)localObject).append(this.a.getAbsolutePath());
        ((StringBuilder)localObject).append(" task.getStatus()->");
        ((StringBuilder)localObject).append(paramDownloadTask.e());
        QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZipAndPatch  file error path->");
      ((StringBuilder)localObject).append(this.a.getAbsolutePath());
      ((StringBuilder)localObject).append(" task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.3
 * JD-Core Version:    0.7.0.1
 */