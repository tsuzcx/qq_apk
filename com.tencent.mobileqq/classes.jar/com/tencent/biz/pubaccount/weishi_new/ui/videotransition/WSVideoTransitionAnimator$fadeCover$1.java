package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimator$fadeCover$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionAnimator$fadeCover$1
  extends AnimatorListenerAdapter
{
  WSVideoTransitionAnimator$fadeCover$1(View paramView) {}
  
  public void onAnimationEnd(@NotNull Animator paramAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimator, "animation");
    this.a.setAlpha(1.0F);
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimator.fadeCover.1
 * JD-Core Version:    0.7.0.1
 */