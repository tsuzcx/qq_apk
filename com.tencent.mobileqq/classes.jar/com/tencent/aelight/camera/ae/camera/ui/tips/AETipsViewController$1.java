package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;

class AETipsViewController$1
  implements Observer<AECaptureModeChangingEvent>
{
  AETipsViewController$1(AETipsViewController paramAETipsViewController) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    AETipsViewController.a(this.a, paramAECaptureModeChangingEvent.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController.1
 * JD-Core Version:    0.7.0.1
 */