package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class AETopRightBarPart$6
  implements Observer<Boolean>
{
  AETopRightBarPart$6(AETopRightBarPart paramAETopRightBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    int i;
    if (paramBoolean.booleanValue()) {
      i = 8;
    } else {
      i = 0;
    }
    if (AETopRightBarPart.j(this.a) != null) {
      AETopRightBarPart.j(this.a).setVisibility(i);
    }
    if (this.a.d != null) {
      this.a.d.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.6
 * JD-Core Version:    0.7.0.1
 */