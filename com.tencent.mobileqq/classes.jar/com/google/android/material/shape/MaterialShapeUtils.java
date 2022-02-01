package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils
{
  @NonNull
  static CornerTreatment a()
  {
    return new RoundedCornerTreatment();
  }
  
  @NonNull
  static CornerTreatment a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return a();
      }
      return new CutCornerTreatment();
    }
    return new RoundedCornerTreatment();
  }
  
  @NonNull
  static EdgeTreatment a()
  {
    return new EdgeTreatment();
  }
  
  public static void a(@NonNull View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable instanceof MaterialShapeDrawable)) {
      a(paramView, (MaterialShapeDrawable)localDrawable);
    }
  }
  
  public static void a(@NonNull View paramView, float paramFloat)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof MaterialShapeDrawable)) {
      ((MaterialShapeDrawable)paramView).r(paramFloat);
    }
  }
  
  public static void a(@NonNull View paramView, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    if (paramMaterialShapeDrawable.f()) {
      paramMaterialShapeDrawable.q(ViewUtils.a(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeUtils
 * JD-Core Version:    0.7.0.1
 */