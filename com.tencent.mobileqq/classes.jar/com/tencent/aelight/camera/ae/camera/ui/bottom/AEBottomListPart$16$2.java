package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEBottomListPart$16$2
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListPart$16$2(AEBottomListPart.16 param16, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" download finish: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" id: ");
    if (paramAEMaterialMetaData == null) {
      paramAEMaterialMetaData = "null";
    } else {
      paramAEMaterialMetaData = paramAEMaterialMetaData.m;
    }
    localStringBuilder.append(paramAEMaterialMetaData);
    AEQLog.b("AEBottomListPart", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.A = true;
      ThreadManager.getUIHandler().post(new AEBottomListPart.16.2.1(this));
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.2
 * JD-Core Version:    0.7.0.1
 */