package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class AEGifMaterialManager$3$1
  implements INetEngineListener
{
  AEGifMaterialManager$3$1(AEGifMaterialManager.3 param3, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp url: ");
      localStringBuilder.append(this.b.a.packageUrl);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("AEGifMaterialManager", 2, localStringBuilder.toString());
    }
    if (AEGifMaterialManager.a(this.b.this$0, this.b.a)) {
      try
      {
        paramNetResp = new File(this.a, this.b.a.id);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(AEPath.CAMERA.FILES.i);
        localStringBuilder.append(File.separator);
        ZipUtils.unZipFile(paramNetResp, localStringBuilder.toString());
        AEGifMaterialManager.b(this.b.this$0, this.b.a);
        AEGifMaterialManager.c(this.b.this$0).remove(this.b.a.id);
        return;
      }
      catch (IOException paramNetResp)
      {
        if (QLog.isColorLevel()) {
          paramNetResp.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    AEGifMaterialManager.a(this.b.this$0, this.b.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!AEGifMaterialManager.c(this.b.this$0).containsKey(this.b.a.id)) {
      AEGifMaterialManager.c(this.b.this$0).put(this.b.a.id, this.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager.3.1
 * JD-Core Version:    0.7.0.1
 */