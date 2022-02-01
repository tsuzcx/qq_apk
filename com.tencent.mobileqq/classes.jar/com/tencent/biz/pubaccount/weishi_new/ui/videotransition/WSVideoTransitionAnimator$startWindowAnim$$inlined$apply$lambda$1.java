package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimator$startWindowAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionAnimator$startWindowAnim$$inlined$apply$lambda$1
  extends AnimatorListenerAdapter
{
  WSVideoTransitionAnimator$startWindowAnim$$inlined$apply$lambda$1(Context paramContext) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null)
    {
      ((Activity)paramAnimator).getWindow().setBackgroundDrawable((Drawable)WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimator.startWindowAnim..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */