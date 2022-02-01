package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;

class AEFlashShowBottomPart$15
  implements Observer<Boolean>
{
  AEFlashShowBottomPart$15(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(Boolean paramBoolean)
  {
    View localView = AEFlashShowBottomPart.d(this.a);
    int j = 0;
    int i;
    if (localView != null)
    {
      localView = AEFlashShowBottomPart.d(this.a);
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (AEFlashShowBottomPart.e(this.a) != null)
    {
      localView = AEFlashShowBottomPart.e(this.a);
      if (paramBoolean.booleanValue()) {
        i = j;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.15
 * JD-Core Version:    0.7.0.1
 */