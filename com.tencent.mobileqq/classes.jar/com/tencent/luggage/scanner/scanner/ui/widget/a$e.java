package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$e
  implements Animator.AnimatorListener
{
  a$e(Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator)
  {
    this.a.b();
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    o.d("Luggage.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
    this.a.b();
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.b;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */