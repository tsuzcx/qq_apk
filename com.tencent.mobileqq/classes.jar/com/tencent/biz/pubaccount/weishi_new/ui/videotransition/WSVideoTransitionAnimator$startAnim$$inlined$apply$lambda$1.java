package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimator$startAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionAnimator$startAnim$$inlined$apply$lambda$1
  extends AnimatorListenerAdapter
{
  WSVideoTransitionAnimator$startAnim$$inlined$apply$lambda$1(AccelerateDecelerateInterpolator paramAccelerateDecelerateInterpolator, Function0 paramFunction01, Function0 paramFunction02, WSAnimConfig paramWSAnimConfig) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.c.invoke();
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    this.b.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimator.startAnim..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */