package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEPituCameraUnit$22
  implements Observer<AECaptureModeChangingEvent>
{
  AEPituCameraUnit$22(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent != null)
    {
      AEPituCameraUnit.a(this.a, paramAECaptureModeChangingEvent.a, paramAECaptureModeChangingEvent.b);
      VideoReport.setPageParams(this.a.s(), "ae_content_type", Integer.valueOf(paramAECaptureModeChangingEvent.b.index));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */