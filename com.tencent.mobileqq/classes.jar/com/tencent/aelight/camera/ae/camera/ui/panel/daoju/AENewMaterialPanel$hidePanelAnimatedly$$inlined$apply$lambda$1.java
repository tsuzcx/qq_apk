package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$hidePanelAnimatedly$animationSet$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AENewMaterialPanel$hidePanelAnimatedly$$inlined$apply$lambda$1
  implements Animation.AnimationListener
{
  AENewMaterialPanel$hidePanelAnimatedly$$inlined$apply$lambda$1(AENewMaterialPanel paramAENewMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    this.a.setVisibility(8);
    paramAnimation = this.b;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.hidePanelAnimatedly..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */