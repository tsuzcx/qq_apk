package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;

class AEBottomListPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEBottomListPart$2(AEBottomListPart paramAEBottomListPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.R();
    AEBottomListPart.a(this.a, paramAECaptureModeChangingEvent.b);
    if (AEBottomListPart.a(this.a) == AECaptureMode.NORMAL)
    {
      AEBottomListPart.a(this.a);
      return;
    }
    if (AEBottomListPart.a(this.a) == AECaptureMode.GIF)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      return;
    }
    if (AEBottomListPart.a(this.a) == AECaptureMode.PLAY) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.2
 * JD-Core Version:    0.7.0.1
 */