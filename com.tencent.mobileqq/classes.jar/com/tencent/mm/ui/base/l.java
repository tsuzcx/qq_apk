package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qx.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "bottomPadding", "Landroid/view/View;", "getBottomPadding", "(Landroid/view/View;)I", "setBottomPadding", "(Landroid/view/View;I)V", "leftPadding", "getLeftPadding", "setLeftPadding", "", "name", "getName", "(Landroid/view/View;)Ljava/lang/String;", "setName", "(Landroid/view/View;Ljava/lang/String;)V", "rightPadding", "getRightPadding", "setRightPadding", "topPadding", "getTopPadding", "setTopPadding", "lp", "T", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(IILkotlin/jvm/functions/Function1;)Landroid/view/ViewGroup$LayoutParams;", "recursiveFindViewByName", "view", "child", "Landroid/view/ViewGroup;", "block", "dp2Px", "Landroid/content/Context;", "dp", "findViewByName", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "getColorById", "id", "getDimensionPixelSize", "getDrawableById", "Landroid/graphics/drawable/Drawable;", "getStringById", "kotlin.jvm.PlatformType", "luggage-commons-widget_release"}, k=2, mv={1, 1, 16})
public final class l
{
  public static final int a(@NotNull Context paramContext, @DimenRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$getDimensionPixelSize");
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  public static final <T extends View> T a(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$findViewByName");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    paramView = b(paramView, paramString);
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    return paramView;
  }
  
  public static final void a(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$leftPadding");
    paramView.setPadding(paramInt, 0, 0, 0);
  }
  
  public static final int b(@NotNull Context paramContext, @Dimension(unit=0) int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$dp2Px");
    return a.e(paramContext, paramInt);
  }
  
  @Nullable
  public static final View b(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (paramView.getId() == paramString.hashCode()) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = paramView.getChildAt(i);
        Intrinsics.checkExpressionValueIsNotNull(localView, "view.getChildAt(i)");
        localView = b(localView, paramString);
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static final void b(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$rightPadding");
    paramView.setPadding(0, 0, paramInt, 0);
  }
  
  public static final int c(@NotNull Context paramContext, @ColorRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$getColorById");
    return ContextCompat.getColor(paramContext, paramInt);
  }
  
  public static final void c(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$topPadding");
    paramView.setPadding(0, paramInt, 0, 0);
  }
  
  public static final void c(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$name");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    if (paramView.getId() == -1)
    {
      if ((StringsKt.isBlank((CharSequence)paramString) ^ true)) {
        paramView.setId(paramString.hashCode());
      }
      return;
    }
    throw ((Throwable)new IllegalArgumentException("already had id"));
  }
  
  public static final String d(@NotNull Context paramContext, @StringRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$getStringById");
    return paramContext.getResources().getString(paramInt);
  }
  
  public static final void d(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$bottomPadding");
    paramView.setPadding(0, 0, 0, paramInt);
  }
  
  @Nullable
  public static final Drawable e(@NotNull Context paramContext, @DrawableRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$getDrawableById");
    return ContextCompat.getDrawable(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.l
 * JD-Core Version:    0.7.0.1
 */