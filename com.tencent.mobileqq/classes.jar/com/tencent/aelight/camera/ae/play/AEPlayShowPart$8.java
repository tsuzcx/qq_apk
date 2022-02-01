package com.tencent.aelight.camera.ae.play;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;

class AEPlayShowPart$8
  implements Observer<Boolean>
{
  AEPlayShowPart$8(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onChanged(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      AEPlayShowPart.access$000(this.this$0).refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart.8
 * JD-Core Version:    0.7.0.1
 */