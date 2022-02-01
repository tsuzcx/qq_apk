package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;

class AEFlashShowBottomPart$16
  implements Observer<Boolean>
{
  AEFlashShowBottomPart$16(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(Boolean paramBoolean)
  {
    if (AEFlashShowBottomPart.s(this.a) != null)
    {
      if (paramBoolean.booleanValue())
      {
        AEFlashShowBottomPart.a(this.a, null);
        return;
      }
      AEFlashShowBottomPart.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.16
 * JD-Core Version:    0.7.0.1
 */