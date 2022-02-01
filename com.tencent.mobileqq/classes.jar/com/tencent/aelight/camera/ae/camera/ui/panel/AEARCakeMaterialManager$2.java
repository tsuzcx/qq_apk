package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEARCakeMaterialManager$2
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEARCakeMaterialManager$2(AEARCakeMaterialManager paramAEARCakeMaterialManager) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : onDownloadFinish ");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEARCakeMaterialManager", localStringBuilder.toString());
    if ((paramAEMaterialMetaData != null) && (paramBoolean))
    {
      ThreadManager.getUIHandler().post(new AEARCakeMaterialManager.2.1(this, paramAEMaterialMetaData));
      return;
    }
    AEQLog.a("AEARCakeMaterialManager", "arcake : can not set material ");
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEARCakeMaterialManager.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager.2
 * JD-Core Version:    0.7.0.1
 */