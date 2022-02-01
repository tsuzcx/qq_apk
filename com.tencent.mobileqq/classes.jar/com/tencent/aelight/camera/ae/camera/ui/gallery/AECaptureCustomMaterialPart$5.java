package com.tencent.aelight.camera.ae.camera.ui.gallery;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DaoJuPanelOpenState;

class AECaptureCustomMaterialPart$5
  implements Observer<DaoJuPanelOpenState>
{
  AECaptureCustomMaterialPart$5(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart) {}
  
  public void a(DaoJuPanelOpenState paramDaoJuPanelOpenState)
  {
    paramDaoJuPanelOpenState = this.a;
    float f;
    if (AECaptureCustomMaterialPart.g(paramDaoJuPanelOpenState).b()) {
      f = 0.0F;
    } else {
      f = AECaptureCustomMaterialPart.h(this.a);
    }
    AECaptureCustomMaterialPart.a(paramDaoJuPanelOpenState, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.5
 * JD-Core Version:    0.7.0.1
 */