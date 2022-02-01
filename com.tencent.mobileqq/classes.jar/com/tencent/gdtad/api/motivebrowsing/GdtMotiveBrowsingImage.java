package com.tencent.gdtad.api.motivebrowsing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mvvm.ResourcesExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingImage;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "circleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "closeDrawable", "Landroid/graphics/drawable/Drawable;", "translate", "", "getTranslate", "()I", "translate$delegate", "Lkotlin/Lazy;", "getCircleDrawable", "getImageDrawable", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingImage
  extends View
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new GdtMotiveBrowsingImage.translate.2(this));
  
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
      localGradientDrawable.setStroke(AIOUtils.a(1.0F, getResources()), Color.parseColor("#E5E5E5"));
      localGradientDrawable.setCornerRadius(AIOUtils.a(18.0F, getResources()));
      int i = AIOUtils.a(33.0F, getResources());
      localGradientDrawable.setBounds(0, 0, i, i);
    }
    GradientDrawable localGradientDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (localGradientDrawable == null) {
      Intrinsics.throwNpe();
    }
    return (Drawable)localGradientDrawable;
  }
  
  private final Drawable b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localObject = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resources");
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ResourcesExtKt.a((Resources)localObject, 2130840392);
      int i = AIOUtils.a(18.0F, getResources());
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
  
  public void onDraw(@Nullable Canvas paramCanvas)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingImage
 * JD-Core Version:    0.7.0.1
 */