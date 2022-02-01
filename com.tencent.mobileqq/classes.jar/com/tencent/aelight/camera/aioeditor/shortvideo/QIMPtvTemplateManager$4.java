package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QIMPtvTemplateManager$4
  implements Runnable
{
  QIMPtvTemplateManager$4(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a))
    {
      this.a.g = true;
      return;
    }
    this.a.g = false;
    int i = (int)(FileUtils.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
    int j = (int)(this.a.V * 1024.0D);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preDownloadTemplates getAvailableInnernalMemorySize: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" mSizeFree: ");
      ((StringBuilder)localObject).append(j);
      QLog.d("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (i < j)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preDownloadTemplates return getAvailableInnernalMemorySize: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" mSizeFree: ");
        ((StringBuilder)localObject).append(j);
        QLog.i("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new QIMPtvTemplateManager.4.1(this);
    ((HttpNetReq)localObject).mReqUrl = this.a.c;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = new File(QIMPtvTemplateManager.l(), this.a.e).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    try
    {
      AppInterface localAppInterface = CaptureContext.a();
      if (localAppInterface != null)
      {
        ((IHttpEngineService)((PeakAppInterface)localAppInterface).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startDownloadFilterConfigZip, url: ");
          ((StringBuilder)localObject).append(this.a.c);
          QLog.i("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */