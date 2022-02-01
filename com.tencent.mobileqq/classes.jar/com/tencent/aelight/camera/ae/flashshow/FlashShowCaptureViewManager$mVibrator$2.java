package com.tencent.aelight.camera.ae.flashshow;

import android.os.Vibrator;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/os/Vibrator;", "invoke"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$mVibrator$2
  extends Lambda
  implements Function0<Vibrator>
{
  FlashShowCaptureViewManager$mVibrator$2(FlashShowCaptureViewManager paramFlashShowCaptureViewManager)
  {
    super(0);
  }
  
  @NotNull
  public final Vibrator invoke()
  {
    Object localObject = FlashShowCaptureViewManager.f(this.this$0).getSystemService("vibrator");
    if (localObject != null) {
      return (Vibrator)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.mVibrator.2
 * JD-Core Version:    0.7.0.1
 */