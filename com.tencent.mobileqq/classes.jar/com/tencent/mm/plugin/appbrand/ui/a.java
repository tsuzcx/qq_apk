package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "fromDPToPix", "", "Landroid/content/Context;", "dp", "hideImmediately", "", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "Landroid/view/View;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  public static final int a(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$fromDPToPix");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return MathKt.roundToInt(paramContext.getDisplayMetrics().density * paramInt);
  }
  
  @JvmStatic
  public static final void a(@Nullable View paramView)
  {
    if (paramView != null)
    {
      paramView.setVisibility(8);
      ViewParent localViewParent = paramView.getParent();
      Object localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(paramView);
      }
    }
  }
  
  @JvmStatic
  public static final void a(@Nullable d paramd)
  {
    if (paramd != null)
    {
      Object localObject = paramd.getView();
      if ((localObject != null) && (((View)localObject).isAttachedToWindow() == true))
      {
        localObject = paramd.getView();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
        localObject = ((View)localObject).getAnimation();
        if (localObject != null) {
          ((Animation)localObject).cancel();
        }
        paramd.getView().animate().cancel();
        localObject = paramd.getView();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
        ((View)localObject).setVisibility(8);
        localObject = paramd.getView();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
        localObject = ((View)localObject).getParent();
        if (localObject != null)
        {
          ((ViewGroup)localObject).removeView(paramd.getView());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */