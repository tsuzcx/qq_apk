package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.Animator;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$openWithAnimation$1$1", "Lcom/tencent/mobileqq/widget/D8SafeAnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialPanel$openWithAnimation$1$1
  extends D8SafeAnimatorListener
{
  public void onAnimationCancel(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
    AEQLog.d("AEFlashShowMaterialPanel", "[openWithAnimation] translationY - onAnimationCancel");
  }
  
  public void onAnimationEnd(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
  }
  
  public void onAnimationRepeat(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
  }
  
  public void onAnimationStart(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialPanel.openWithAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */