package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
final class h
  extends f
  implements i.a
{
  private Animator b;
  private final AppBrandOptionButton c;
  
  public h(@NotNull AppBrandOptionButton paramAppBrandOptionButton)
  {
    this.c = paramAppBrandOptionButton;
  }
  
  private final void f()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.c.getButtonImage();
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
  }
  
  public void a()
  {
    b(null);
  }
  
  protected void a(int paramInt) {}
  
  protected void a(@Nullable Drawable paramDrawable)
  {
    AppBrandOptionButton localAppBrandOptionButton = this.c;
    f();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.a();
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = a((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {
      localObject = null;
    } else {
      localObject = localAnimator;
    }
    Object localObject = (ValueAnimator)localObject;
    if (localObject != null) {
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h.a(localAppBrandOptionButton, paramDrawable));
    }
    localAnimator.start();
    this.b = localAnimator;
  }
  
  protected void a(@Nullable CharSequence paramCharSequence) {}
  
  protected void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.c.post(paramRunnable);
    }
  }
  
  @NotNull
  protected Context b()
  {
    Context localContext = this.c.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "mButton.context");
    return localContext;
  }
  
  public void b(int paramInt) {}
  
  public void b(@Nullable Drawable paramDrawable)
  {
    a(paramDrawable);
  }
  
  public void b(@Nullable CharSequence paramCharSequence) {}
  
  public void c()
  {
    f();
  }
  
  public void c(int paramInt) {}
  
  public final void d()
  {
    Animator localAnimator = this.b;
    if (localAnimator != null) {
      localAnimator.resume();
    }
  }
  
  public void d(int paramInt) {}
  
  public final void e()
  {
    Animator localAnimator = this.b;
    if (localAnimator != null) {
      localAnimator.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h
 * JD-Core Version:    0.7.0.1
 */