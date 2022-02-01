package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;

class PlayDownloadManagerWrap$1
  implements Runnable
{
  PlayDownloadManagerWrap$1(PlayDownloadManagerWrap paramPlayDownloadManagerWrap, AEMaterialManager paramAEMaterialManager, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener) {}
  
  public void run()
  {
    AEMaterialManager localAEMaterialManager = this.val$materialManager;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), this.val$templateInfo, this.val$downloadListener);
    this.val$templateInfo.B = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.1
 * JD-Core Version:    0.7.0.1
 */