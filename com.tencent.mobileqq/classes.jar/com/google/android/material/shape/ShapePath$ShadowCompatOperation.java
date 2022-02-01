package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.google.android.material.shadow.ShadowRenderer;

abstract class ShapePath$ShadowCompatOperation
{
  static final Matrix b = new Matrix();
  
  public abstract void a(Matrix paramMatrix, ShadowRenderer paramShadowRenderer, int paramInt, Canvas paramCanvas);
  
  public final void a(ShadowRenderer paramShadowRenderer, int paramInt, Canvas paramCanvas)
  {
    a(b, paramShadowRenderer, paramInt, paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.ShadowCompatOperation
 * JD-Core Version:    0.7.0.1
 */