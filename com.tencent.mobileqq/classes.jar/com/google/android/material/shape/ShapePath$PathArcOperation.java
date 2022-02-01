package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;

public class ShapePath$PathArcOperation
  extends ShapePath.PathOperation
{
  private static final RectF h = new RectF();
  @Deprecated
  public float a;
  @Deprecated
  public float b;
  @Deprecated
  public float c;
  @Deprecated
  public float d;
  @Deprecated
  public float e;
  @Deprecated
  public float f;
  
  public ShapePath$PathArcOperation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat1);
    b(paramFloat2);
    c(paramFloat3);
    d(paramFloat4);
  }
  
  private float a()
  {
    return this.a;
  }
  
  private void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  private float b()
  {
    return this.b;
  }
  
  private void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  private float c()
  {
    return this.c;
  }
  
  private void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  private float d()
  {
    return this.d;
  }
  
  private void d(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  private float e()
  {
    return this.e;
  }
  
  private void e(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  private float f()
  {
    return this.f;
  }
  
  private void f(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void a(@NonNull Matrix paramMatrix, @NonNull Path paramPath)
  {
    Matrix localMatrix = this.g;
    paramMatrix.invert(localMatrix);
    paramPath.transform(localMatrix);
    h.set(a(), b(), c(), d());
    paramPath.arcTo(h, e(), f(), false);
    paramPath.transform(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.PathArcOperation
 * JD-Core Version:    0.7.0.1
 */