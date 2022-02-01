package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper$applyLogo$1$1"}, k=3, mv={1, 1, 16})
final class h$a
  implements ValueAnimator.AnimatorUpdateListener
{
  h$a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.getButtonImage().setImageDrawable(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h.a
 * JD-Core Version:    0.7.0.1
 */