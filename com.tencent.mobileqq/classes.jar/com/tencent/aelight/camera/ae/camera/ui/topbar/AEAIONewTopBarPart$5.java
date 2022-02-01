package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;

class AEAIONewTopBarPart$5
  implements Observer<Boolean>
{
  AEAIONewTopBarPart$5(AEAIONewTopBarPart paramAEAIONewTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    View localView = AEAIONewTopBarPart.d(this.a);
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
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.5
 * JD-Core Version:    0.7.0.1
 */