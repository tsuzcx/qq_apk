package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;

class AETopRightBarPart$4
  implements Observer<Boolean>
{
  AETopRightBarPart$4(AETopRightBarPart paramAETopRightBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    View localView = this.a.a;
    int i;
    if (paramBoolean.booleanValue()) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.4
 * JD-Core Version:    0.7.0.1
 */