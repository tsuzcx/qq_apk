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
    if (this.this$0.a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo, true))
    {
      this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.a = true;
      return;
    }
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new PtvTemplateManager.4.1(this);
    ((HttpNetReq)localObject).mReqUrl = this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.c;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = new File(PtvTemplateManager.a(), this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.b).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.c);
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */