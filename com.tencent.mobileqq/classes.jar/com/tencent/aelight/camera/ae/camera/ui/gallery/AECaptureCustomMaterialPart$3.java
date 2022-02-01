package com.tencent.aelight.camera.ae.camera.ui.gallery;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;

class AECaptureCustomMaterialPart$3
  implements Observer<Boolean>
{
  AECaptureCustomMaterialPart$3(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      AECaptureCustomMaterialPart.e(this.a);
      return;
    }
    if (!AECaptureCustomMaterialPart.g(this.a).b()) {
      AECaptureCustomMaterialPart.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.3
 * JD-Core Version:    0.7.0.1
 */