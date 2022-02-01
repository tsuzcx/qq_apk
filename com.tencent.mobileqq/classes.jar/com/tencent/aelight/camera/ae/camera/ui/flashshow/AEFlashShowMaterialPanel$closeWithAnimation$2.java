package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$closeWithAnimation$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialPanel$closeWithAnimation$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    paramAnimation = AEFlashShowMaterialPanel.b(this.a);
    if (paramAnimation != null) {
      paramAnimation.setAlpha(1.0F);
    }
    paramAnimation = AEFlashShowMaterialPanel.b(this.a);
    if (paramAnimation != null) {
      paramAnimation.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel.closeWithAnimation.2
 * JD-Core Version:    0.7.0.1
 */