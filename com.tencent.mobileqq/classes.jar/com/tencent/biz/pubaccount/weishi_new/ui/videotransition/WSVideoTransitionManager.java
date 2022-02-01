package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionManager;", "", "()V", "coverContainerForAnim", "Landroid/view/ViewGroup;", "ivCoverForAnim", "Landroid/widget/ImageView;", "getAnimConfig", "Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSAnimConfig;", "rootView", "Landroid/view/View;", "smallElementRect", "Landroid/graphics/RectF;", "bigElementRect", "getCoverEndTopMargin", "", "endAnimRect", "rootHeight", "getCoverStartTopMargin", "startAnimRect", "startScale", "getWindowBgStartAlpha", "", "context", "Landroid/content/Context;", "initCoverViewForAnim", "", "drawable", "Landroid/graphics/drawable/Drawable;", "initCoverViewSize", "coverViewForAnim", "startEnterAnim", "startExitAnim", "onExitAnimEndListener", "Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionManager$OnExitAnimEndListener;", "Companion", "OnExitAnimEndListener", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionManager
{
  public static final WSVideoTransitionManager.Companion a = new WSVideoTransitionManager.Companion(null);
  private ViewGroup b;
  private ImageView c;
  
  private final float a(RectF paramRectF, float paramFloat)
  {
    float f = WSVideoTransitionAnimUtil.a.a();
    if (paramRectF.height() / paramRectF.width() > 1.555556F) {
      return 0.0F;
    }
    return (paramFloat - f - paramRectF.height()) / 2;
  }
  
  private final float a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    float f = WSVideoTransitionAnimUtil.a.a();
    if (paramRectF2.height() / paramRectF2.width() > 1.555556F) {
      return (paramRectF2.height() - paramRectF1.height() / paramFloat2) / 2;
    }
    return (paramFloat1 - f - paramRectF1.height() / paramFloat2) / 2;
  }
  
  private final int a(Context paramContext)
  {
    int j = (int)127.5F;
    int i = j;
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = paramContext instanceof Activity;
      Object localObject1 = null;
      if (!bool) {
        paramContext = null;
      }
      Object localObject2 = (Activity)paramContext;
      paramContext = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((Activity)localObject2).getWindow();
        paramContext = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((Window)localObject2).getDecorView();
          paramContext = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((View)localObject2).getBackground();
            paramContext = localObject1;
            if (localObject2 != null) {
              paramContext = Integer.valueOf(((Drawable)localObject2).getAlpha());
            }
          }
        }
      }
      i = j;
      if (paramContext != null)
      {
        if (paramContext.intValue() == 0) {
          return j;
        }
        i = paramContext.intValue();
      }
    }
    return i;
  }
  
  private final WSAnimConfig a(View paramView1, View paramView2, RectF paramRectF1, RectF paramRectF2)
  {
    int i = paramView1.getMeasuredHeight();
    float f1 = paramRectF1.width() / paramRectF2.width();
    float f2 = paramView1.getScaleX();
    float f3 = paramRectF1.width() / paramRectF1.height();
    float f4 = paramRectF2.width() / paramRectF2.height();
    float f5 = i;
    float f6 = a(paramRectF1, paramRectF2, f5, f1);
    float f7 = a(paramRectF2, f5);
    float f8 = paramRectF1.left;
    float f12 = 1 - f1;
    float f9 = paramRectF2.width();
    float f13 = 2;
    f9 = f9 * f12 / f13;
    float f10 = paramView1.getTranslationX();
    float f11 = paramRectF1.top;
    f12 = f12 * f5 / f13;
    f13 = paramView1.getTranslationY();
    return new WSAnimConfig.Builder().a(paramView1).b(paramView2).a(1, f1, f2).a(2, f8 - f9, f10).a(3, f11 - f12 - f6 * f1, f13).a(4, f3, f4).a(6, f6, f7).a(7, f6, 0.0F).a(5, paramRectF2.width() / f3, f5).a();
  }
  
  private final void a(ImageView paramImageView, View paramView, RectF paramRectF1, RectF paramRectF2)
  {
    if (paramRectF1 == null) {
      return;
    }
    paramImageView = (View)paramImageView;
    paramRectF1 = a(paramView, paramImageView, paramRectF1, paramRectF2);
    float f = paramRectF1.a(4);
    int i = (int)paramRectF1.a(6);
    WSVideoTransitionAnimator.a.a(paramImageView, paramView.getMeasuredWidth(), f, i);
  }
  
  public final void a(@NotNull View paramView, @NotNull RectF paramRectF1, @NotNull RectF paramRectF2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "rootView");
    Intrinsics.checkParameterIsNotNull(paramRectF1, "startAnimRect");
    Intrinsics.checkParameterIsNotNull(paramRectF2, "endAnimRect");
    paramRectF1 = a(paramView, (View)this.c, paramRectF1, paramRectF2);
    WSVideoTransitionAnimator.a(WSVideoTransitionAnimator.a, paramRectF1, (Function0)new WSVideoTransitionManager.startEnterAnim.1(paramView, paramRectF1), (Function0)new WSVideoTransitionManager.startEnterAnim.2(this), false, 8, null);
  }
  
  public final void a(@NotNull ViewGroup paramViewGroup, @NotNull RectF paramRectF1, @NotNull RectF paramRectF2, @NotNull WSVideoTransitionManager.OnExitAnimEndListener paramOnExitAnimEndListener)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "rootView");
    Intrinsics.checkParameterIsNotNull(paramRectF1, "startAnimRect");
    Intrinsics.checkParameterIsNotNull(paramRectF2, "endAnimRect");
    Intrinsics.checkParameterIsNotNull(paramOnExitAnimEndListener, "onExitAnimEndListener");
    paramRectF1 = a((View)paramViewGroup, (View)this.c, paramRectF2, paramRectF1);
    WSVideoTransitionAnimator.a.a(paramRectF1, (Function0)new WSVideoTransitionManager.startExitAnim.1(this), (Function0)new WSVideoTransitionManager.startExitAnim.2(paramOnExitAnimEndListener), true);
    WSVideoTransitionAnimator.a.a(paramViewGroup.getContext(), a(paramViewGroup.getContext()), 0);
  }
  
  public final void a(@NotNull ViewGroup paramViewGroup, @Nullable Drawable paramDrawable, @Nullable RectF paramRectF1, @NotNull RectF paramRectF2)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "rootView");
    Intrinsics.checkParameterIsNotNull(paramRectF2, "endAnimRect");
    ImageView localImageView = new ImageView(paramViewGroup.getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, -1));
    localImageView.setImageDrawable(paramDrawable);
    a(localImageView, (View)paramViewGroup, paramRectF1, paramRectF2);
    paramDrawable = new FrameLayout(paramViewGroup.getContext());
    paramRectF1 = new ViewGroup.MarginLayoutParams(-1, -1);
    paramRectF1.bottomMargin = WSVideoTransitionAnimUtil.a.a();
    paramDrawable.setLayoutParams((ViewGroup.LayoutParams)paramRectF1);
    paramDrawable.setBackgroundColor(-16777216);
    paramDrawable.addView((View)localImageView);
    paramViewGroup.addView((View)paramDrawable);
    this.c = localImageView;
    this.b = ((ViewGroup)paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager
 * JD-Core Version:    0.7.0.1
 */