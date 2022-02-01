package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

class AEBottomListPart$9
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListPart$9(AEBottomListPart paramAEBottomListPart) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    paramAEMaterialMetaData = new StringBuilder();
    paramAEMaterialMetaData.append("loadAndHandleData---download finish, isSuccess=");
    paramAEMaterialMetaData.append(paramBoolean);
    AEQLog.b("AEBottomListPart", paramAEMaterialMetaData.toString());
    if (!paramBoolean)
    {
      AEBottomListPart.a(this.a, true);
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.1(this));
    }
    AEBottomListPart.f(this.a).countDown();
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if ((paramInt > 1) && (paramInt <= 100)) {
      ThreadManager.getUIHandler().post(new AEBottomListPart.9.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.9
 * JD-Core Version:    0.7.0.1
 */