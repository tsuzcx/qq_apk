package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$i
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    paramAnimator = a.d(this.a);
    if (paramAnimator != null)
    {
      int i = ((Number)paramAnimator).intValue();
      paramAnimator = a.c(this.a).findViewById(i);
      if (paramAnimator != null) {
        ((LinearLayout)a.c(this.a).findViewById(2131431280)).removeView(paramAnimator);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.i
 * JD-Core Version:    0.7.0.1
 */