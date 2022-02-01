package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PtvTemplateManager$4$1
  implements INetEngineListener
{
  PtvTemplateManager$4$1(PtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp url: ");
      localStringBuilder.append(this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.c);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.a = this.a.this$0.a(this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo, false);
    if (this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.a) {
      try
      {
        ZipUtils.unZipFile(new File(PtvTemplateManager.a(), this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.b), PtvTemplateManager.a());
      }
      catch (IOException localIOException)
      {
        QLog.e("PtvTemplateManager", 1, "preDownloadDoodleTemplate error, ", localIOException);
      }
    }
    this.a.this$0.a(this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.a);
    if (paramNetResp.mResult == 0)
    {
      IPreDownloadController localIPreDownloadController = (IPreDownloadController)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class);
      if (localIPreDownloadController.isEnable()) {
        localIPreDownloadController.preDownloadSuccess(this.a.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfo.c, paramNetResp.mTotalFileLen);
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.4.1
 * JD-Core Version:    0.7.0.1
 */