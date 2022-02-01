package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AENewMaterialAdapter$selectSpecificMaterial$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", "use material failed because of so load failed");
    if (AEKitForQQ.a()) {
      FeatureManager.loadBasicFeatures();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter.selectSpecificMaterial.1
 * JD-Core Version:    0.7.0.1
 */