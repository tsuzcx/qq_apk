package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class AEGifMaterialManager$3
  implements Runnable
{
  AEGifMaterialManager$3(AEGifMaterialManager paramAEGifMaterialManager, MetaMaterial paramMetaMaterial, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (AEGifMaterialManager.a(this.this$0, this.a))
    {
      AEGifMaterialManager.b(this.this$0, this.a);
      AEGifMaterialManager.c(this.this$0).remove(this.a.id);
      return;
    }
    if (this.this$0.a(this.a.id))
    {
      AEGifMaterialManager.a(this.this$0, this.a, 0);
      return;
    }
    Object localObject = AEPath.CAMERA.FILES.h;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEGifMaterialManager.3.1(this, (String)localObject);
    localHttpNetReq.mReqUrl = this.a.packageUrl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File((String)localObject, this.a.id).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.b.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject).append(this.a.packageUrl);
      QLog.i("AEGifMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager.3
 * JD-Core Version:    0.7.0.1
 */