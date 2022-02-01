package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEFlashShowMaterialAdapter$selectSpecificMaterial$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
    if (AEKitForQQ.a()) {
      FeatureManager.loadBasicFeatures();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter.selectSpecificMaterial.1
 * JD-Core Version:    0.7.0.1
 */