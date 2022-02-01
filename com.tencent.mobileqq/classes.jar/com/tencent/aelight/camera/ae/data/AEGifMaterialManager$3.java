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
    if (AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial))
    {
      AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
      AEGifMaterialManager.a(this.this$0).remove(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
      return;
    }
    if (this.this$0.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
    {
      AEGifMaterialManager.a(this.this$0, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, 0);
      return;
    }
    Object localObject = AEPath.CAMERA.FILES.h;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEGifMaterialManager.3.1(this, (String)localObject);
    localHttpNetReq.mReqUrl = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.packageUrl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File((String)localObject, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTemplate, url: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.packageUrl);
      QLog.i("AEGifMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager.3
 * JD-Core Version:    0.7.0.1
 */