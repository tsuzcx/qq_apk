package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.List;
import mqq.os.MqqHandler;

class AEWaterMarkPanel$6
  implements Runnable
{
  AEWaterMarkPanel$6(AEWaterMarkPanel paramAEWaterMarkPanel) {}
  
  public void run()
  {
    List localList = AEWatermarkMaterialManager.a().b();
    if (CollectionUtils.isEmpty(localList)) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEWaterMarkPanel.6.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.6
 * JD-Core Version:    0.7.0.1
 */