package com.tencent.aelight.camera.ae.flashshow;

import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.OnTabSwitchListener;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager$initModeSwitchView$1", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$OnTabSwitchListener;", "switchTo", "", "position", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowCaptureViewManager$initModeSwitchView$1
  implements FlashShowSwitchLayout.OnTabSwitchListener
{
  public void a(int paramInt)
  {
    int i = 2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          AEQLog.d("FlashShowCaptureViewManager", "ignore invalid position");
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switch to mode: ");
    localStringBuilder.append(i);
    AEQLog.b("FlashShowCaptureViewManager", localStringBuilder.toString());
    FlashShowCaptureViewManager.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager.initModeSwitchView.1
 * JD-Core Version:    0.7.0.1
 */