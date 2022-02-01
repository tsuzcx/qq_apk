package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimator;", "", "()V", "DURATION_COVER_FADE", "", "DURATION_TRANSITION_ANIM", "PROPERTY_NAME_ALPHA", "", "TAG", "windowBgDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getWindowBgDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "windowBgDrawable$delegate", "Lkotlin/Lazy;", "fadeCover", "", "coverView", "Landroid/view/View;", "getCurValue", "", "animConfig", "Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSAnimConfig;", "valueType", "", "animatedValue", "setClipArea", "view", "clipTop", "clipHeight", "setCoverLayoutParams", "width", "curRatio", "curTopMargin", "setScale", "scale", "setTranslation", "translationX", "translationY", "startAnim", "onAnimStartCallback", "Lkotlin/Function0;", "onAnimEndCallback", "isReverse", "", "startWindowAnim", "context", "Landroid/content/Context;", "startAlpha", "endAlpha", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionAnimator
{
  public static final WSVideoTransitionAnimator a = new WSVideoTransitionAnimator();
  private static final Lazy b = LazyKt.lazy((Function0)WSVideoTransitionAnimator.windowBgDrawable.2.INSTANCE);
  
  private final float a(WSAnimConfig paramWSAnimConfig, int paramInt, float paramFloat)
  {
    float f = paramWSAnimConfig.a(paramInt);
    return f + (paramWSAnimConfig.b(paramInt) - f) * paramFloat;
  }
  
  private final ColorDrawable a()
  {
    return (ColorDrawable)b.getValue();
  }
  
  public final void a(@Nullable Context paramContext, int paramInt1, int paramInt2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(a(), "alpha", new int[] { paramInt1, paramInt2 }).setDuration(300L);
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator, "this");
    localObjectAnimator.setInterpolator(localObjectAnimator.getInterpolator());
    localObjectAnimator.addListener((Animator.AnimatorListener)new WSVideoTransitionAnimator.startWindowAnim..inlined.apply.lambda.1(paramContext));
    localObjectAnimator.start();
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "coverView");
    paramView.animate().alpha(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new WSVideoTransitionAnimator.fadeCover.1(paramView)).start();
  }
  
  public final void a(@NotNull View paramView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView.setPivotX(paramView.getWidth() / 2.0F);
    paramView.setPivotY(paramView.getHeight() / 2.0F);
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
  
  public final void a(@NotNull View paramView, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public final void a(@Nullable View paramView, int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(paramInt1 / paramFloat));
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt2;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
  
  public final void a(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ((WSDragFrameLayout)paramView).setClipVertical(paramInt1, paramInt2);
    paramView.invalidate();
  }
  
  public final void a(@NotNull WSAnimConfig paramWSAnimConfig, @NotNull Function0<Unit> paramFunction01, @NotNull Function0<Unit> paramFunction02, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramWSAnimConfig, "animConfig");
    Intrinsics.checkParameterIsNotNull(paramFunction01, "onAnimStartCallback");
    Intrinsics.checkParameterIsNotNull(paramFunction02, "onAnimEndCallback");
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (!paramBoolean)
    {
      f1 = 0.0F;
      f2 = 1.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, f2 }).setDuration(300L);
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "this");
    localValueAnimator.setInterpolator((TimeInterpolator)localAccelerateDecelerateInterpolator);
    localValueAnimator.addListener((Animator.AnimatorListener)new WSVideoTransitionAnimator.startAnim..inlined.apply.lambda.1(localAccelerateDecelerateInterpolator, paramFunction01, paramFunction02, paramWSAnimConfig));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new WSVideoTransitionAnimator.startAnim..inlined.apply.lambda.2(localAccelerateDecelerateInterpolator, paramFunction01, paramFunction02, paramWSAnimConfig));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimator
 * JD-Core Version:    0.7.0.1
 */