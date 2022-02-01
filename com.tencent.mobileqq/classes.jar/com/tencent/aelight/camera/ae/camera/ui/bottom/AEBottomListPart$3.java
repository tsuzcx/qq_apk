package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;

class AEBottomListPart$3
  implements Observer<Boolean>
{
  AEBottomListPart$3(AEBottomListPart paramAEBottomListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (AEBottomListPart.a(this.a).a())
    {
      this.a.a.setVisibility(8);
      return;
    }
    if (AEBottomListPart.a(this.a).b())
    {
      if (!AEBottomListPart.a(this.a))
      {
        AEBottomListScrollView localAEBottomListScrollView = this.a.a;
        int i;
        if (paramBoolean.booleanValue()) {
          i = 0;
        } else {
          i = 4;
        }
        localAEBottomListScrollView.setVisibility(i);
        return;
      }
      this.a.a.setVisibility(8);
      return;
    }
    if (AEBottomListPart.a(this.a).c()) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.3
 * JD-Core Version:    0.7.0.1
 */