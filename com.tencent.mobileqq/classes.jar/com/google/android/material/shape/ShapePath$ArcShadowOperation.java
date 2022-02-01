package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;

class ShapePath$ArcShadowOperation
  extends ShapePath.ShadowCompatOperation
{
  private final ShapePath.PathArcOperation a;
  
  public ShapePath$ArcShadowOperation(ShapePath.PathArcOperation paramPathArcOperation)
  {
    this.a = paramPathArcOperation;
  }
  
  public void a(Matrix paramMatrix, @NonNull ShadowRenderer paramShadowRenderer, int paramInt, @NonNull Canvas paramCanvas)
  {
    float f1 = ShapePath.PathArcOperation.a(this.a);
    float f2 = ShapePath.PathArcOperation.b(this.a);
    paramShadowRenderer.a(paramCanvas, paramMatrix, new RectF(ShapePath.PathArcOperation.c(this.a), ShapePath.PathArcOperation.d(this.a), ShapePath.PathArcOperation.e(this.a), ShapePath.PathArcOperation.f(this.a)), paramInt, f1, f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.ArcShadowOperation
 * JD-Core Version:    0.7.0.1
 */