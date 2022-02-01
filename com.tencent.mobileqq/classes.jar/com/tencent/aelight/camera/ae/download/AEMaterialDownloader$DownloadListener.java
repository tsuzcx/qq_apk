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
  private AEMaterialMetaData a;
  private String b;
  private AEMaterialDownloader.MaterialDownloadListener c;
  
  public AEMaterialDownloader$DownloadListener(AEMaterialMetaData paramAEMaterialMetaData, String paramString, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    this.a = paramAEMaterialMetaData;
    this.b = paramString;
    this.c = paramMaterialDownloadListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = AEMaterialDownloader.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResp url: ");
      ((StringBuilder)localObject2).append(this.a.r);
      ((StringBuilder)localObject2).append(" resultcode: ");
      ((StringBuilder)localObject2).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject2).append(" cakeid :");
      ((StringBuilder)localObject2).append(this.a.V);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.a;
    if ((localObject1 instanceof AEPreDownloadResMetaData))
    {
      TTAutoAISceneAni.a((AEPreDownloadResMetaData)localObject1);
      this.a.A = true;
    }
    else
    {
      ((AEMaterialMetaData)localObject1).A = AEMaterialManager.a((AEMaterialMetaData)localObject1);
    }
    localObject1 = this.a;
    ((AEMaterialMetaData)localObject1).B = false;
    Object localObject2 = this.c;
    if (localObject2 != null) {
      ((AEMaterialDownloader.MaterialDownloadListener)localObject2).onDownloadFinish((AEMaterialMetaData)localObject1, ((AEMaterialMetaData)localObject1).A, paramNetResp.mHttpCode);
    }
    if (paramNetResp.mErrCode != 0)
    {
      AEBaseDataReporter.a().a(this.a.m, paramNetResp.mErrCode, paramNetResp.reqCost, 0L, this.a.s);
      return;
    }
    if ((paramNetResp.mErrCode == 0) && (!this.a.A))
    {
      AEBaseDataReporter.a().a(this.a.m, 1111, paramNetResp.reqCost, 0L, this.a.s);
      return;
    }
    localObject1 = new File(this.b, this.a.t);
    long l;
    if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
      l = ((File)localObject1).length();
    } else {
      l = 0L;
    }
    AEBaseDataReporter.a().a(this.a.m, paramNetResp.mErrCode, paramNetResp.reqCost, l, this.a.s);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.a;
    paramNetReq.E = paramLong2;
    paramNetReq.C = ((int)(paramLong1 * 100L / paramLong2));
    AEMaterialDownloader.MaterialDownloadListener localMaterialDownloadListener = this.c;
    if (localMaterialDownloadListener != null) {
      localMaterialDownloadListener.onProgressUpdate(paramNetReq, paramNetReq.C);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEMaterialDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */