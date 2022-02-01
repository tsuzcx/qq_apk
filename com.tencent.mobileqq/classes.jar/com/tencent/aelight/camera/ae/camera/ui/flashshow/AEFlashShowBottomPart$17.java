package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;

class AEFlashShowBottomPart$17
  implements Observer<Boolean>
{
  AEFlashShowBottomPart$17(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (AEFlashShowBottomPart.s(this.a) != null)
    {
      if (!paramBoolean.booleanValue())
      {
        AEFlashShowBottomPart.s(this.a).setVisibility(8);
        return;
      }
      AEFlashShowBottomPart.s(this.a).setVisibility(0);
      AEFlashShowBottomPart.d(this.a).setVisibility(8);
      AEFlashShowBottomPart.e(this.a).setVisibility(8);
      AEFlashShowBottomPart.n(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.17
 * JD-Core Version:    0.7.0.1
 */