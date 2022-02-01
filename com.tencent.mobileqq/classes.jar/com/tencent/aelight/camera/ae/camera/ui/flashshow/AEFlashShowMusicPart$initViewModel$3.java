package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowMusicButton;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "musicState", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMusicState;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$3<T>
  implements Observer<AEFlashShowMusicState>
{
  AEFlashShowMusicPart$initViewModel$3(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(AEFlashShowMusicState paramAEFlashShowMusicState)
  {
    if (paramAEFlashShowMusicState.a())
    {
      FlashShowMusicButton localFlashShowMusicButton = AEFlashShowMusicPart.j(this.a);
      if (localFlashShowMusicButton != null)
      {
        paramAEFlashShowMusicState = paramAEFlashShowMusicState.b();
        if (paramAEFlashShowMusicState == null) {
          paramAEFlashShowMusicState = "播放音乐";
        }
        localFlashShowMusicButton.setMusicOn(paramAEFlashShowMusicState);
      }
    }
    else
    {
      paramAEFlashShowMusicState = AEFlashShowMusicPart.j(this.a);
      if (paramAEFlashShowMusicState != null) {
        paramAEFlashShowMusicState.setMusicOff();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.3
 * JD-Core Version:    0.7.0.1
 */