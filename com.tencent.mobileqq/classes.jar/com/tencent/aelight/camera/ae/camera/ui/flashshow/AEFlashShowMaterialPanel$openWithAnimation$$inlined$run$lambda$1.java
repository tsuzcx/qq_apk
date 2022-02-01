package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$openWithAnimation$2$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialPanel$openWithAnimation$$inlined$run$lambda$1
  implements Animation.AnimationListener
{
  AEFlashShowMaterialPanel$openWithAnimation$$inlined$run$lambda$1(AEFlashShowMaterialPanel paramAEFlashShowMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    AEFlashShowMaterialPanel.a(this.a, false);
    paramAnimation = AEFlashShowMaterialPanel.c(this.a);
    if (paramAnimation != null) {
      paramAnimation.b();
    }
    paramAnimation = this.b;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    AEFlashShowMaterialPanel.a(this.a, true);
    if (AEFlashShowMaterialPanel.b(this.a) != null)
    {
      paramAnimation = AEFlashShowMaterialPanel.b(this.a);
      if (paramAnimation != null) {
        paramAnimation.setAlpha(1.0F);
      }
      paramAnimation = AEFlashShowMaterialPanel.b(this.a);
      if (paramAnimation != null) {
        paramAnimation.setVisibility(0);
      }
    }
    else
    {
      AEQLog.d("AEFlashShowMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel.openWithAnimation..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */