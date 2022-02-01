package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.TabLayout;

class AEFlashShowMultiUnit$4
  implements Observer<Boolean>
{
  AEFlashShowMultiUnit$4(AEFlashShowMultiUnit paramAEFlashShowMultiUnit) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((AEFlashShowMultiUnit.b(this.a) != null) && (!paramBoolean.booleanValue())) {
      AEFlashShowMultiUnit.b(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowMultiUnit.4
 * JD-Core Version:    0.7.0.1
 */