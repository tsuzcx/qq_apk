package com.tencent.aelight.camera.ae.data;

import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEMaterialManager$4
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEMaterialManager$4(AEMaterialManager paramAEMaterialManager, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.a(this.b, paramAEMaterialMetaData);
    if (localAEMaterialMetaData != null) {
      localAEMaterialMetaData.A = AEMaterialManager.a(paramAEMaterialMetaData);
    }
    AEMaterialDownloader.MaterialDownloadListener localMaterialDownloadListener = this.a;
    if (localMaterialDownloadListener != null)
    {
      localMaterialDownloadListener.onDownloadFinish(paramAEMaterialMetaData, paramBoolean, paramInt);
      if (localAEMaterialMetaData != null)
      {
        paramAEMaterialMetaData = new StringBuilder();
        paramAEMaterialMetaData.append("【END】onDownloadFinish :");
        paramAEMaterialMetaData.append(localAEMaterialMetaData.m);
        AEQLog.b("AEMaterialManager", paramAEMaterialMetaData.toString());
      }
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    AEMaterialDownloader.MaterialDownloadListener localMaterialDownloadListener = this.a;
    if (localMaterialDownloadListener != null) {
      localMaterialDownloadListener.onProgressUpdate(paramAEMaterialMetaData, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialManager.4
 * JD-Core Version:    0.7.0.1
 */