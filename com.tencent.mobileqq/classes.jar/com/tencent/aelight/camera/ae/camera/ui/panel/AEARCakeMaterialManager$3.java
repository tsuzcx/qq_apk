package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEARCakeMaterialManager$3
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEARCakeMaterialManager$3(AEARCakeMaterialManager paramAEARCakeMaterialManager) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : onDownloadFinish ");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEARCakeMaterialManager", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEARCakeMaterialManager.3.1(this, paramInt, paramAEMaterialMetaData, paramBoolean));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEARCakeMaterialManager.3.2(this, paramAEMaterialMetaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.3
 * JD-Core Version:    0.7.0.1
 */