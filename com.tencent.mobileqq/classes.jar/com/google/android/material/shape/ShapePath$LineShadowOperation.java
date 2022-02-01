package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;

class ShapePath$LineShadowOperation
  extends ShapePath.ShadowCompatOperation
{
  private final float jdField_a_of_type_Float;
  private final ShapePath.PathLineOperation jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation;
  private final float b;
  
  public ShapePath$LineShadowOperation(ShapePath.PathLineOperation paramPathLineOperation, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation = paramPathLineOperation;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  float a()
  {
    return (float)Math.toDegrees(Math.atan((ShapePath.PathLineOperation.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation) - this.b) / (ShapePath.PathLineOperation.b(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation) - this.jdField_a_of_type_Float)));
  }
  
  public void a(Matrix paramMatrix, @NonNull ShadowRenderer paramShadowRenderer, int paramInt, @NonNull Canvas paramCanvas)
  {
    float f1 = ShapePath.PathLineOperation.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation);
    float f2 = this.b;
    float f3 = ShapePath.PathLineOperation.b(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath$PathLineOperation);
    float f4 = this.jdField_a_of_type_Float;
    RectF localRectF = new RectF(0.0F, 0.0F, (float)Math.hypot(f1 - f2, f3 - f4), 0.0F);
    paramMatrix = new Matrix(paramMatrix);
    paramMatrix.preTranslate(this.jdField_a_of_type_Float, this.b);
    paramMatrix.preRotate(a());
    paramShadowRenderer.a(paramCanvas, paramMatrix, localRectF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.LineShadowOperation
 * JD-Core Version:    0.7.0.1
 */