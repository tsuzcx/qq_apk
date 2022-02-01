package com.tencent.aelight.camera.aioeditor.capture.util;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ConfigSimplifier$1
  implements INetEngineListener
{
  ConfigSimplifier$1(ConfigSimplifier paramConfigSimplifier, String paramString1, String paramString2, ConfigSimplifier.ZipConfig paramZipConfig, String paramString3, String paramString4, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp resultcode: ");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject).append(" threadid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.i("ConfigSimplifier_PTV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(this.a, this.b);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      return;
    }
    try
    {
      paramNetResp = FileUtils.calcMd5(((File)localObject).getPath());
    }
    catch (UnsatisfiedLinkError paramNetResp)
    {
      QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramNetResp);
      paramNetResp = "";
    }
    if ((!TextUtils.isEmpty(this.c.c)) && (this.c.c.equalsIgnoreCase(paramNetResp))) {
      try
      {
        ZipUtils.unZipFile((File)localObject, this.d);
      }
      catch (IOException paramNetResp)
      {
        QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramNetResp);
      }
    } else if (QLog.isColorLevel()) {
      QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.c.c, " ", paramNetResp });
    }
    paramNetResp = new File(this.e);
    if (paramNetResp.exists())
    {
      paramNetResp = QIMPtvTemplateManager.a(paramNetResp);
      localObject = this.f;
      if ((localObject != null) && (paramNetResp != null)) {
        ((ConfigSimplifier.ConfigDownloadCallback)localObject).a(paramNetResp);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier.1
 * JD-Core Version:    0.7.0.1
 */