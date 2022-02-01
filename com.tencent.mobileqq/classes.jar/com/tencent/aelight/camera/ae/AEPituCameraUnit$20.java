package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;

class AEPituCameraUnit$20
  implements Observer<AECaptureModeChangingEvent>
{
  AEPituCameraUnit$20(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent != null) {
      AEPituCameraUnit.a(this.a, paramAECaptureModeChangingEvent.a, paramAECaptureModeChangingEvent.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */