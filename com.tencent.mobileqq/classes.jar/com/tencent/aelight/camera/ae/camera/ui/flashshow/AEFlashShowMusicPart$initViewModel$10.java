package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowMusicButton;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "visible", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$10<T>
  implements Observer<Boolean>
{
  AEFlashShowMusicPart$initViewModel$10(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(Boolean paramBoolean)
  {
    AEFlashShowMusicPart localAEFlashShowMusicPart = this.a;
    if (!paramBoolean.booleanValue())
    {
      paramBoolean = AEFlashShowMusicPart.j(localAEFlashShowMusicPart);
      if (paramBoolean != null) {
        paramBoolean.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.10
 * JD-Core Version:    0.7.0.1
 */