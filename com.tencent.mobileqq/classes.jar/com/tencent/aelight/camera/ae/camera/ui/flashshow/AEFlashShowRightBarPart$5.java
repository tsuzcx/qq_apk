package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;

class AEFlashShowRightBarPart$5
  implements Observer<Boolean>
{
  AEFlashShowRightBarPart$5(AEFlashShowRightBarPart paramAEFlashShowRightBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      int i;
      if (paramBoolean.booleanValue()) {
        i = 8;
      } else {
        i = 0;
      }
      this.a.a.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart.5
 * JD-Core Version:    0.7.0.1
 */