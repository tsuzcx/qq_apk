package com.tencent.aelight.camera.ae.camera.ui.gallery;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;

class AECaptureCustomMaterialPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AECaptureCustomMaterialPart$2(AECaptureCustomMaterialPart paramAECaptureCustomMaterialPart) {}
  
  public void a(AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    AECaptureCustomMaterialPart.a(this.a, paramAECaptureModeChangingEvent.b);
    if (AECaptureCustomMaterialPart.d(this.a) == AECaptureMode.NORMAL)
    {
      AECaptureCustomMaterialPart.e(this.a);
      return;
    }
    AECaptureCustomMaterialPart.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.2
 * JD-Core Version:    0.7.0.1
 */