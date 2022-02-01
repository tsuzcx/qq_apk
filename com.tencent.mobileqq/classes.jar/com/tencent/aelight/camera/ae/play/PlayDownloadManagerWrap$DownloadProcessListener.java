package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.qphone.base.util.QLog;

class PlayDownloadManagerWrap$DownloadProcessListener
  implements AEMaterialDownloader.MaterialDownloadListener
{
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramAEMaterialMetaData.f = false;
    if (paramBoolean)
    {
      paramAEMaterialMetaData.e = true;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download failed with id: ");
      localStringBuilder.append(paramAEMaterialMetaData.k);
      QLog.e("PlayDownloadManagerWrap", 1, localStringBuilder.toString());
    }
    PlayDownloadManagerWrap.getInstance().notifyDownloadFinish(paramAEMaterialMetaData, paramBoolean);
    PlayDownloadManagerWrap.access$300(PlayDownloadManagerWrap.getInstance(), paramAEMaterialMetaData.k);
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    PlayDownloadManagerWrap.getInstance().notifyDownloadProgress(paramAEMaterialMetaData.k, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.DownloadProcessListener
 * JD-Core Version:    0.7.0.1
 */