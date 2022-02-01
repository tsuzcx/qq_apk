package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;

public abstract interface AEMaterialDownloader$MaterialDownloadListener
{
  public abstract void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt);
  
  public abstract void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener
 * JD-Core Version:    0.7.0.1
 */