package com.tencent.aelight.camera.ae.mode;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;

class AEVideoStoryCaptureModePart$3
  implements Observer<Boolean>
{
  AEVideoStoryCaptureModePart$3(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (AEVideoStoryCaptureModePart.g(this.a))
    {
      View localView = AEVideoStoryCaptureModePart.h(this.a);
      int i;
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 4;
      }
      localView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.3
 * JD-Core Version:    0.7.0.1
 */