package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;

class AEFlashShowBottomPart$12
  implements Observer<Boolean>
{
  AEFlashShowBottomPart$12(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (AEFlashShowBottomPart.t(this.a) == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      AEFlashShowBottomPart.t(this.a).an_();
      return;
    }
    if (AEFlashShowBottomPart.s(this.a) != null) {
      AEFlashShowBottomPart.s(this.a).setVisibility(0);
    }
    AEFlashShowBottomPart.t(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.12
 * JD-Core Version:    0.7.0.1
 */