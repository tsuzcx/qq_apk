package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.Style;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "style", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashCameraCaptureButtonLayout$Style;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class FlashShowCaptureViewManager$initViewModel$4<T>
  implements Observer<AEFlashCameraCaptureButtonLayout.Style>
{
  FlashShowCaptureViewManager$initViewModel$4(FlashShowCaptureViewManager paramFlashShowCaptureViewManager) {}
  
  public final void a(AEFlashCameraCaptureButtonLayout.Style paramStyle)
  {
    if ((paramStyle == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) && (FlashShowCaptureViewManager.c(this.a) != 1))
    {
      FlashShowSwitchLayout localFlashShowSwitchLayout = FlashShowCaptureViewManager.b(this.a);
      if (localFlashShowSwitchLayout != null) {
        localFlashShowSwitchLayout.setCurrentItem(1, false);
      }
      FlashShowCaptureViewManager.d(this.a);
    }
    if ((paramStyle == AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE) && (FlashShowCaptureViewManager.c(this.a) != 0))
    {
      paramStyle = FlashShowCaptureViewManager.b(this.a);
      if (paramStyle != null) {
        paramStyle.setCurrentItem(0, false);
      }
      FlashShowCaptureViewManager.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.initViewModel.4
 * JD-Core Version:    0.7.0.1
 */