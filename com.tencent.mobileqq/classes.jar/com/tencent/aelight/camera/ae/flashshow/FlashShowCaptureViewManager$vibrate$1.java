package com.tencent.aelight.camera.ae.flashshow;

import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$vibrate$1
  implements Runnable
{
  FlashShowCaptureViewManager$vibrate$1(FlashShowCaptureViewManager paramFlashShowCaptureViewManager) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT > 25)
    {
      VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(50L, -1);
      FlashShowCaptureViewManager.e(this.this$0).vibrate(localVibrationEffect);
      return;
    }
    FlashShowCaptureViewManager.e(this.this$0).vibrate(50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.vibrate.1
 * JD-Core Version:    0.7.0.1
 */