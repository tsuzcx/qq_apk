package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialProviderView$mCaptureConfigUpdateObserver$1", "Lcom/tencent/aelight/camera/aioeditor/capture/music/CaptureConfigUpdateObserver;", "onFaceUUpdate", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialProviderView$mCaptureConfigUpdateObserver$1
  extends CaptureConfigUpdateObserver
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFlashShowMaterialProviderView", 2, "mCaptureConfigUpdateObserver material list updated!");
    }
    if (AEFlashShowMaterialProviderView.e(this.a)) {
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialProviderView.mCaptureConfigUpdateObserver.1
 * JD-Core Version:    0.7.0.1
 */