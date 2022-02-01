package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "visible", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$initViewModel$3<T>
  implements Observer<Boolean>
{
  FlashShowCaptureViewManager$initViewModel$3(FlashShowCaptureViewManager paramFlashShowCaptureViewManager) {}
  
  public final void a(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue())
    {
      paramBoolean = FlashShowCaptureViewManager.b(this.a);
      if (paramBoolean != null) {
        paramBoolean.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.initViewModel.3
 * JD-Core Version:    0.7.0.1
 */