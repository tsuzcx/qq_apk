package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class MaskEvaluator
{
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final ShapeAppearancePathProvider jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider = ShapeAppearancePathProvider.a();
  private final Path b = new Path();
  private final Path c = new Path();
  
  Path a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPath;
  }
  
  ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  }
  
  void a(float paramFloat, ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, MaterialContainerTransform.ProgressThresholds paramProgressThresholds)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = TransitionUtils.a(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, paramRectF3, paramProgressThresholds.a(), paramProgressThresholds.b(), paramFloat);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, 1.0F, paramRectF2, this.b);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, 1.0F, paramRectF3, this.c);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_AndroidGraphicsPath.op(this.b, this.c, Path.Op.UNION);
    }
  }
  
  void a(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      return;
    }
    paramCanvas.clipPath(this.b);
    paramCanvas.clipPath(this.c, Region.Op.UNION);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.MaskEvaluator
 * JD-Core Version:    0.7.0.1
 */