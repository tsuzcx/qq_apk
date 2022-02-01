package com.tencent.gdtad.basics.motivebrowsing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingImage;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "circleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "closeDrawable", "Landroid/graphics/drawable/Drawable;", "translate", "", "getTranslate", "()I", "translate$delegate", "Lkotlin/Lazy;", "getCircleDrawable", "getImageDrawable", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "getDrawableCompat", "Landroid/content/res/Resources;", "id", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingImage
  extends View
{
  private GradientDrawable a;
  private Drawable b;
  private final Lazy c = LazyKt.lazy((Function0)GdtMotiveBrowsingImage.translate.2.INSTANCE);
  
  public GdtMotiveBrowsingImage(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final Drawable a(@NotNull Resources paramResources, @DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = paramResources.getDrawable(paramInt, null);
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id, null)");
      return paramResources;
    }
    paramResources = paramResources.getDrawable(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id)");
    return paramResources;
  }
  
  private final Drawable getCircleDrawable()
  {
    if (this.a == null)
    {
      this.a = new GradientDrawable();
      localGradientDrawable = this.a;
      if (localGradientDrawable == null) {
        Intrinsics.throwNpe();
      }
      localGradientDrawable.setStroke(ViewUtils.dpToPx(1.0F), Color.parseColor("#E5E5E5"));
      localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(18.0F));
      int i = ViewUtils.dpToPx(33.0F);
      localGradientDrawable.setBounds(0, 0, i, i);
    }
    GradientDrawable localGradientDrawable = this.a;
    if (localGradientDrawable == null) {
      Intrinsics.throwNpe();
    }
    return (Drawable)localGradientDrawable;
  }
  
  private final Drawable getImageDrawable()
  {
    if (this.b == null)
    {
      localObject = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resources");
      this.b = a((Resources)localObject, 2130840585);
      int i = ViewUtils.dpToPx(18.0F);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
    }
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  private final int getTranslate()
  {
    return ((Number)this.c.getValue()).intValue();
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      getCircleDrawable().draw(paramCanvas);
      paramCanvas.save();
      paramCanvas.translate(getTranslate(), getTranslate());
      getImageDrawable().draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingImage
 * JD-Core Version:    0.7.0.1
 */