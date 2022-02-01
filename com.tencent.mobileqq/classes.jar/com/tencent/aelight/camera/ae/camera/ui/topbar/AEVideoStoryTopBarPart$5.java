package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;

class AEVideoStoryTopBarPart$5
  implements Observer<Boolean>
{
  AEVideoStoryTopBarPart$5(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    View localView = AEVideoStoryTopBarPart.l(this.a);
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
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.5
 * JD-Core Version:    0.7.0.1
 */