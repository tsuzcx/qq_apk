package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAISceneAni;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEPreDownloadResMetaData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AEMaterialDownloader$DownloadListener
  implements INetEngineListener
{
  private AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  private AEMaterialDownloader.MaterialDownloadListener jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public AEMaterialDownloader$DownloadListener(AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener = paramMaterialDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = AEMaterialDownloader.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResp url: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.n);
      ((StringBuilder)localObject2).append(" resultcode: ");
      ((StringBuilder)localObject2).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject2).append(" cakeid :");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.C);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    if ((localObject1 instanceof AEPreDownloadResMetaData))
    {
      TTAutoAISceneAni.a((AEPreDownloadResMetaData)localObject1);
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.e = true;
    }
    else
    {
      ((AEMaterialMetaData)localObject1).e = AEMaterialManager.a((AEMaterialMetaData)localObject1);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    ((AEMaterialMetaData)localObject1).jdField_f_of_type_Boolean = false;
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener;
    if (localObject2 != null) {
      ((AEMaterialDownloader.MaterialDownloadListener)localObject2).onDownloadFinish((AEMaterialMetaData)localObject1, ((AEMaterialMetaData)localObject1).e, paramNetResp.mHttpCode);
    }
    if (paramNetResp.mErrCode != 0)
    {
      AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k, paramNetResp.mErrCode, paramNetResp.reqCost, 0L, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.o);
      return;
    }
    if ((paramNetResp.mErrCode == 0) && (!this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.e))
    {
      AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k, 1111, paramNetResp.reqCost, 0L, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.o);
      return;
    }
    localObject1 = new File(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.p);
    long l;
    if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
      l = ((File)localObject1).length();
    } else {
      l = 0L;
    }
    AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k, paramNetResp.mErrCode, paramNetResp.reqCost, l, this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.o);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
    paramNetReq.b = paramLong2;
    paramNetReq.jdField_f_of_type_Int = ((int)(paramLong1 * 100L / paramLong2));
    AEMaterialDownloader.MaterialDownloadListener localMaterialDownloadListener = this.jdField_a_of_type_ComTencentAelightCameraAeDownloadAEMaterialDownloader$MaterialDownloadListener;
    if (localMaterialDownloadListener != null) {
      localMaterialDownloadListener.onProgressUpdate(paramNetReq, paramNetReq.jdField_f_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEMaterialDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */