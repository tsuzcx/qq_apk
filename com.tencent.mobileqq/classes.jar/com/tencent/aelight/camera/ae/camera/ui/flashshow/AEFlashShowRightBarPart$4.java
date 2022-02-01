package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class AEFlashShowRightBarPart$4
  implements Observer<Boolean>
{
  AEFlashShowRightBarPart$4(AEFlashShowRightBarPart paramAEFlashShowRightBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    int i;
    if (paramBoolean.booleanValue()) {
      i = 8;
    } else {
      i = 0;
    }
    if (AEFlashShowRightBarPart.b(this.a) != null) {
      AEFlashShowRightBarPart.b(this.a).setVisibility(i);
    }
    if (AEFlashShowRightBarPart.c(this.a) != null) {
      AEFlashShowRightBarPart.c(this.a).setVisibility(i);
    }
    if (AEFlashShowRightBarPart.d(this.a) != null) {
      AEFlashShowRightBarPart.d(this.a).setVisibility(i);
    }
    if (this.a.d != null) {
      this.a.d.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart.4
 * JD-Core Version:    0.7.0.1
 */