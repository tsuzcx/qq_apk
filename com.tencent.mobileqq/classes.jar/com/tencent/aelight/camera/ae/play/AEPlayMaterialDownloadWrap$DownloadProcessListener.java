package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.qphone.base.util.QLog;

class AEPlayMaterialDownloadWrap$DownloadProcessListener
  implements AEMaterialDownloader.MaterialDownloadListener
{
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramAEMaterialMetaData.B = false;
    if (paramBoolean)
    {
      paramAEMaterialMetaData.A = true;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download failed with id: ");
      localStringBuilder.append(paramAEMaterialMetaData.m);
      QLog.e("AEPlayMaterialDownloadWrap", 1, localStringBuilder.toString());
    }
    AEPlayMaterialDownloadWrap.getInstance().notifyDownloadFinish(paramAEMaterialMetaData, paramBoolean);
    AEPlayMaterialDownloadWrap.access$300(AEPlayMaterialDownloadWrap.getInstance(), paramAEMaterialMetaData.m);
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    AEPlayMaterialDownloadWrap.getInstance().notifyDownloadProgress(paramAEMaterialMetaData.m, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayMaterialDownloadWrap.DownloadProcessListener
 * JD-Core Version:    0.7.0.1
 */