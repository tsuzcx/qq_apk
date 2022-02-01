package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;

class AEFlashShowBottomPart$13
  implements Observer<Boolean>
{
  AEFlashShowBottomPart$13(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (AEFlashShowBottomPart.u(this.a) == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      AEFlashShowBottomPart.u(this.a).e();
      return;
    }
    if (AEFlashShowBottomPart.s(this.a) != null) {
      AEFlashShowBottomPart.s(this.a).setVisibility(0);
    }
    AEFlashShowBottomPart.u(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.13
 * JD-Core Version:    0.7.0.1
 */