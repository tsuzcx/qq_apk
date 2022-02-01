package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;

class AEFlashShowBottomPart$14
  implements Observer<AEFlashCameraCaptureButtonLayout.Style>
{
  AEFlashShowBottomPart$14(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(AEFlashCameraCaptureButtonLayout.Style paramStyle)
  {
    if (AEFlashShowBottomPart.n(this.a) == null) {
      return;
    }
    AEFlashShowBottomPart.n(this.a).setCaptureBtnStyle(paramStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.14
 * JD-Core Version:    0.7.0.1
 */