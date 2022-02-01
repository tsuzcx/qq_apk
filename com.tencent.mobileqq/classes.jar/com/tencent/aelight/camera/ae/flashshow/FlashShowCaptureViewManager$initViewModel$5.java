package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "visble", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$initViewModel$5<T>
  implements Observer<Boolean>
{
  FlashShowCaptureViewManager$initViewModel$5(FlashShowCaptureViewManager paramFlashShowCaptureViewManager) {}
  
  public final void a(Boolean paramBoolean)
  {
    paramBoolean = FlashShowCaptureViewManager.b(this.a);
    if (paramBoolean != null) {
      paramBoolean.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.initViewModel.5
 * JD-Core Version:    0.7.0.1
 */