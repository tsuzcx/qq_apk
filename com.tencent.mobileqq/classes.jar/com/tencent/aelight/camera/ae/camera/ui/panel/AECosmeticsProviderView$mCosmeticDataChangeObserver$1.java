package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsProviderView$mCosmeticDataChangeObserver$1", "Lcom/tencent/aelight/camera/aioeditor/capture/music/CaptureConfigUpdateObserver;", "onFaceUUpdate", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AECosmeticsProviderView$mCosmeticDataChangeObserver$1
  extends CaptureConfigUpdateObserver
{
  public void a()
  {
    if (AECosmeticsProviderView.d(this.a)) {
      return;
    }
    DYAEEffectItem localDYAEEffectItem = (DYAEEffectItem)AECosmeticsProviderView.c(this.a).b().getValue();
    if ((localDYAEEffectItem == null) || (DYAEEffectItemExtKt.a(localDYAEEffectItem))) {
      AECosmeticsProviderView.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsProviderView.mCosmeticDataChangeObserver.1
 * JD-Core Version:    0.7.0.1
 */