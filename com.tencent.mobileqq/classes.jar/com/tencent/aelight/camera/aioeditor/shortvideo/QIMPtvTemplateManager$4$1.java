package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class QIMPtvTemplateManager$4$1
  implements INetEngineListener
{
  QIMPtvTemplateManager$4$1(QIMPtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp url: ");
      localStringBuilder.append(this.a.a.c);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("QIMPtvTemplateManager", 2, localStringBuilder.toString());
    }
    this.a.a.b = this.a.this$0.a(this.a.a);
    if (this.a.a.b) {
      try
      {
        ZipUtils.unZipFile(new File(QIMPtvTemplateManager.a(), this.a.a.e), QIMPtvTemplateManager.a);
      }
      catch (IOException paramNetResp)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
    }
    if (this.a.this$0.a() != null) {
      this.a.this$0.a().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.4.1
 * JD-Core Version:    0.7.0.1
 */