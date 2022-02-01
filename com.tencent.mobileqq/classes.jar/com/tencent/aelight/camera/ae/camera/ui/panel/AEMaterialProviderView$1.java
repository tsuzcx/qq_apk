package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.qphone.base.util.QLog;

class AEMaterialProviderView$1
  extends CaptureConfigUpdateObserver
{
  AEMaterialProviderView$1(AEMaterialProviderView paramAEMaterialProviderView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialProviderView", 2, "material list updated!");
    }
    if (AEMaterialProviderView.a(this.a)) {
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.1
 * JD-Core Version:    0.7.0.1
 */