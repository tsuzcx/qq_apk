package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/scanner/scanner/ui/widget/ScanSharedMaskView$startTitleAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$f
  implements Animator.AnimatorListener
{
  b$f(boolean paramBoolean) {}
  
  public void onAnimationCancel(@Nullable Animator paramAnimator)
  {
    o.f("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationCancel show: %b", new Object[] { Boolean.valueOf(this.b) });
  }
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    boolean bool = this.b;
    int i = 0;
    o.f("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationEnd show: %b, isFlashShow: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.d(this.a)) });
    paramAnimator = b.e(this.a);
    if (!this.b) {
      i = 8;
    }
    paramAnimator.setVisibility(i);
    if (this.b)
    {
      b.e(this.a).invalidate();
      b.f(this.a);
      return;
    }
    if (!b.d(this.a)) {
      b.b(this.a, true);
    }
  }
  
  public void onAnimationRepeat(@Nullable Animator paramAnimator) {}
  
  public void onAnimationStart(@Nullable Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.b.f
 * JD-Core Version:    0.7.0.1
 */