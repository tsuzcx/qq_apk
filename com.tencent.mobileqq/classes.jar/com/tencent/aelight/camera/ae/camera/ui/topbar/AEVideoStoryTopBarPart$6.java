package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;

class AEVideoStoryTopBarPart$6
  implements Observer<Boolean>
{
  AEVideoStoryTopBarPart$6(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    View localView = AEVideoStoryTopBarPart.a(this.a);
    int i;
    if (paramBoolean.booleanValue()) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.6
 * JD-Core Version:    0.7.0.1
 */