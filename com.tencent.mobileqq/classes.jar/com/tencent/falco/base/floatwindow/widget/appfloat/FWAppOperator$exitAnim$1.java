package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/falco/base/floatwindow/widget/appfloat/FWAppOperator$exitAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWAppOperator$exitAnim$1
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    FWAppOperator.access$floatOver(this.this$0);
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    this.this$0.getConfig().isAnim = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator.exitAnim.1
 * JD-Core Version:    0.7.0.1
 */