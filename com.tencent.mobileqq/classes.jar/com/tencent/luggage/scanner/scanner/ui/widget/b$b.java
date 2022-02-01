package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$b
  implements Animator.AnimatorListener
{
  b$b(boolean paramBoolean) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator)
  {
    b.c(this.a, this.b);
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    b.c(this.a, this.b);
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.b.b
 * JD-Core Version:    0.7.0.1
 */