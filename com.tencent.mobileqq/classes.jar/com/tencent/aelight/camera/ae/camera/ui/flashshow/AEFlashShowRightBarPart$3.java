package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;

class AEFlashShowRightBarPart$3
  implements Observer<AEFlashCameraCaptureButtonLayout.Style>
{
  AEFlashShowRightBarPart$3(AEFlashShowRightBarPart paramAEFlashShowRightBarPart) {}
  
  public void a(AEFlashCameraCaptureButtonLayout.Style paramStyle)
  {
    int i = AEFlashShowRightBarPart.7.a[paramStyle.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      AEFlashShowRightBarPart.a(this.a, AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE);
      return;
    }
    AEFlashShowRightBarPart.a(this.a, AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart.3
 * JD-Core Version:    0.7.0.1
 */