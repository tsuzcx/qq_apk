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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)GdtMotiveBrowsingImage.translate.2.INSTANCE);
  
  public GdtMotiveBrowsingImage(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final int a()
  {
    return ((Number)this.jdField_a_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
      localGradientDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
      if (localGradientDrawable == null) {
        Intrinsics.throwNpe();
      }
      localGradientDrawable.setStroke(ViewUtils.b(1.0F), Color.parseColor("#E5E5E5"));
      localGradientDrawable.setCornerRadius(ViewUtils.b(18.0F));
      int i = ViewUtils.b(33.0F);
      localGradientDrawable.setBounds(0, 0, i, i);
    }
    GradientDrawable localGradientDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (localGradientDrawable == null) {
      Intrinsics.throwNpe();
    }
    return (Drawable)localGradientDrawable;
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
  
  private final Drawable b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localObject = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resources");
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a((Resources)localObject, 2130840267);
      int i = ViewUtils.b(18.0F);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      a().draw(paramCanvas);
      paramCanvas.save();
      paramCanvas.translate(a(), a());
      b().draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingImage
 * JD-Core Version:    0.7.0.1
 */