package com.tencent.aelight.camera.ae.mode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;

class AEVideoStoryCaptureModePart$AECaptureModeAdapter$1
  implements View.OnClickListener
{
  AEVideoStoryCaptureModePart$AECaptureModeAdapter$1(AEVideoStoryCaptureModePart.AECaptureModeAdapter paramAECaptureModeAdapter, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart$AECaptureModeAdapter.a, this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF) {
      AEBaseDataReporter.a().P();
    } else if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL) {
      AEBaseDataReporter.a().O();
    } else if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.PLAY) {
      AEBaseDataReporter.a().Y();
    }
    paramView = new StringBuilder();
    paramView.append("【AE_CAPTURE_MODE】:");
    paramView.append(this.jdField_a_of_type_Int);
    AEQLog.b("AEVideoStoryCaptureModePart", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter.1
 * JD-Core Version:    0.7.0.1
 */