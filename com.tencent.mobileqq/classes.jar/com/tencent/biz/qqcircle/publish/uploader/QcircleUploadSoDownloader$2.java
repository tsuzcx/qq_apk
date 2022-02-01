package com.tencent.biz.qqcircle.publish.uploader;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QzoneModuleConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostSoDownloadHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QcircleUploadSoDownloader$2
  implements IQCirclrModuleDownloadListener
{
  QcircleUploadSoDownloader$2(QcircleUploadSoDownloader paramQcircleUploadSoDownloader) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QcircleUploadSoDownloader.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    QcircleUploadSoDownloader.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals(QCircleHostConstants.QzoneModuleConst.QZONE_MODULE_UPLOAD_SO())) {
      return;
    }
    QcircleUploadSoDownloader.b(false);
    String str = QcircleUploadSoDownloader.b().getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload so download success : ");
    ((StringBuilder)localObject).append(str);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
    paramString = QCircleHostSoDownloadHelper.getModuleFilePath(paramString);
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (!HostFileUtils.unzip(new File(paramString), (File)localObject))
    {
      QLog.d("[upload2]QcircleUploadSoDownloader", 1, "upload so unzip fail");
      QcircleUploadSoDownloader.b(false);
      return;
    }
    if (QcircleUploadSoDownloader.a(this.a, str))
    {
      QLog.d("[upload2]QcircleUploadSoDownloader", 1, "upload so save success");
      QcircleUploadSoDownloader.a(this.a, true);
      QcircleUploadSoDownloader.a(true);
    }
    else
    {
      try
      {
        ((File)localObject).delete();
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      QcircleUploadSoDownloader.a(this.a, false);
    }
    QcircleUploadSoDownloader.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadSoDownloader.2
 * JD-Core Version:    0.7.0.1
 */