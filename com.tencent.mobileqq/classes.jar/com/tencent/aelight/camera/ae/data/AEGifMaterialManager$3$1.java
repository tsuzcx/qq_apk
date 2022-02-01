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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a.packageUrl);
      localStringBuilder.append(" resultcode: ");
      localStringBuilder.append(paramNetResp.mHttpCode);
      QLog.i("AEGifMaterialManager", 2, localStringBuilder.toString());
    }
    if (AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a)) {
      try
      {
        paramNetResp = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a.id);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(AEPath.CAMERA.FILES.i);
        localStringBuilder.append(File.separator);
        ZipUtils.unZipFile(paramNetResp, localStringBuilder.toString());
        AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a);
        AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0).remove(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a.id);
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
    AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0).containsKey(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a.id)) {
      AEGifMaterialManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.this$0).put(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a.id, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager$3.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager.3.1
 * JD-Core Version:    0.7.0.1
 */