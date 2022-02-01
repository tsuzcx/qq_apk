package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowBottomPanel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "show", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$2<T>
  implements Observer<Boolean>
{
  AEFlashShowMusicPart$initViewModel$2(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(Boolean paramBoolean)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "show");
    if (paramBoolean.booleanValue())
    {
      paramBoolean = AEFlashShowMusicPart.i(this.a);
      if (paramBoolean != null) {
        paramBoolean.a();
      }
      paramBoolean = AEFlashShowMusicPart.f(this.a);
      if (paramBoolean != null) {
        paramBoolean.performClick();
      }
      AEFlashShowMusicPart.d(this.a).c();
      return;
    }
    paramBoolean = AEFlashShowMusicPart.i(this.a);
    if (paramBoolean != null) {
      paramBoolean.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.2
 * JD-Core Version:    0.7.0.1
 */