package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/falco/base/floatwindow/widget/appfloat/FWAppOperator$enterAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWAppOperator$enterAnim$1
  implements Animator.AnimatorListener
{
  FWAppOperator$enterAnim$1(View paramView) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.this$0.getConfig().isAnim = false;
    this.this$0.getParams().flags = 40;
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    this.$floatingView.setVisibility(0);
    this.this$0.getConfig().isAnim = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator.enterAnim.1
 * JD-Core Version:    0.7.0.1
 */