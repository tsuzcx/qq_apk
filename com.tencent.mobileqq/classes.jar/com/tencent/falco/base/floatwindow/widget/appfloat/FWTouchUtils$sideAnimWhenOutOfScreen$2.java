package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/falco/base/floatwindow/widget/appfloat/FWTouchUtils$sideAnimWhenOutOfScreen$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWTouchUtils$sideAnimWhenOutOfScreen$2
  implements Animator.AnimatorListener
{
  FWTouchUtils$sideAnimWhenOutOfScreen$2(View paramView) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.this$0.getConfig().isAnim = false;
    paramAnimator = this.this$0.getConfig().callbacks;
    if (paramAnimator != null) {
      paramAnimator.dragEnd(this.$view);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    this.this$0.getConfig().isAnim = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils.sideAnimWhenOutOfScreen.2
 * JD-Core Version:    0.7.0.1
 */