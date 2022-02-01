package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "visible", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$initViewModel$1<T>
  implements Observer<Boolean>
{
  FlashShowCaptureViewManager$initViewModel$1(FlashShowCaptureViewManager paramFlashShowCaptureViewManager) {}
  
  public final void a(Boolean paramBoolean)
  {
    FlashShowSwitchLayout localFlashShowSwitchLayout = FlashShowCaptureViewManager.b(this.a);
    if (localFlashShowSwitchLayout != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "visible");
      int i;
      if (paramBoolean.booleanValue()) {
        i = 0;
      } else {
        i = 4;
      }
      localFlashShowSwitchLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.initViewModel.1
 * JD-Core Version:    0.7.0.1
 */