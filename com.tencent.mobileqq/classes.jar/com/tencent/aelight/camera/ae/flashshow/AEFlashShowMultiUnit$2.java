package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.TabLayout;

class AEFlashShowMultiUnit$2
  implements Observer<Boolean>
{
  AEFlashShowMultiUnit$2(AEFlashShowMultiUnit paramAEFlashShowMultiUnit) {}
  
  public void a(Boolean paramBoolean)
  {
    AEFlashShowMultiUnit.a(this.a);
    TabLayout localTabLayout = AEFlashShowMultiUnit.b(this.a);
    int i;
    if (paramBoolean.booleanValue()) {
      i = 4;
    } else {
      i = 0;
    }
    localTabLayout.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowMultiUnit.2
 * JD-Core Version:    0.7.0.1
 */