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
    AEVideoStoryCaptureModePart.b(this.c.a, this.a);
    if (this.a == AECaptureMode.GIF) {
      AEBaseDataReporter.a().Q();
    } else if (this.a == AECaptureMode.NORMAL) {
      AEBaseDataReporter.a().P();
    } else if (this.a == AECaptureMode.PLAY) {
      AEBaseDataReporter.a().Z();
    }
    paramView = new StringBuilder();
    paramView.append("【AE_CAPTURE_MODE】:");
    paramView.append(this.b);
    AEQLog.b("AEVideoStoryCaptureModePart", paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter.1
 * JD-Core Version:    0.7.0.1
 */