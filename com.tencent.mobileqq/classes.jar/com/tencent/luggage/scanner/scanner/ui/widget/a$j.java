package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.luggage.wxa.dl.e;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$j
  implements Animator.AnimatorListener
{
  a$j(a parama) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    o.f("Luggage.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
    paramAnimator = a.f(this.a);
    if (paramAnimator != null) {
      paramAnimator.b();
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator)
  {
    paramAnimator = a.f(this.a);
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.j
 * JD-Core Version:    0.7.0.1
 */