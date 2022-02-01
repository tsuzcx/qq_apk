package com.tencent.aelight.camera.ae.flashshow;

import android.view.View;
import androidx.annotation.RequiresApi;

class AEFlashShowCameraUnit$2
  implements Runnable
{
  AEFlashShowCameraUnit$2(AEFlashShowCameraUnit paramAEFlashShowCameraUnit) {}
  
  @RequiresApi(api=21)
  public void run()
  {
    if (AEFlashShowCameraUnit.a(this.this$0) != null)
    {
      AEFlashShowCameraUnit.b(this.this$0).setOutlineProvider(new AEFlashShowCameraUnit.2.1(this));
      AEFlashShowCameraUnit.c(this.this$0).setClipToOutline(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.2
 * JD-Core Version:    0.7.0.1
 */