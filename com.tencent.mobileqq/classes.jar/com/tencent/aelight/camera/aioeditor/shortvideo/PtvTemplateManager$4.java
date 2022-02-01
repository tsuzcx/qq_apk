package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$4
  implements Runnable
{
  PtvTemplateManager$4(PtvTemplateManager paramPtvTemplateManager, DoodleInfo paramDoodleInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a(this.a, true))
    {
      this.a.e = true;
      return;
    }
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new PtvTemplateManager.4.1(this);
    ((HttpNetReq)localObject).mReqUrl = this.a.c;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = new File(PtvTemplateManager.f(), this.a.b).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject).append(this.a.c);
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */