package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;

class ShapePath$LineShadowOperation
  extends ShapePath.ShadowCompatOperation
{
  private final ShapePath.PathLineOperation a;
  private final float b;
  private final float c;
  
  public ShapePath$LineShadowOperation(ShapePath.PathLineOperation paramPathLineOperation, float paramFloat1, float paramFloat2)
  {
    this.a = paramPathLineOperation;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  float a()
  {
    return (float)Math.toDegrees(Math.atan((ShapePath.PathLineOperation.a(this.a) - this.c) / (ShapePath.PathLineOperation.b(this.a) - this.b)));
  }
  
  public void a(Matrix paramMatrix, @NonNull ShadowRenderer paramShadowRenderer, int paramInt, @NonNull Canvas paramCanvas)
  {
    float f1 = ShapePath.PathLineOperation.a(this.a);
    float f2 = this.c;
    float f3 = ShapePath.PathLineOperation.b(this.a);
    float f4 = this.b;
    RectF localRectF = new RectF(0.0F, 0.0F, (float)Math.hypot(f1 - f2, f3 - f4), 0.0F);
    paramMatrix = new Matrix(paramMatrix);
    paramMatrix.preTranslate(this.b, this.c);
    paramMatrix.preRotate(a());
    paramShadowRenderer.a(paramCanvas, paramMatrix, localRectF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.LineShadowOperation
 * JD-Core Version:    0.7.0.1
 */