package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

public class ShapePath$PathQuadOperation
  extends ShapePath.PathOperation
{
  @Deprecated
  public float a;
  @Deprecated
  public float b;
  @Deprecated
  public float c;
  @Deprecated
  public float d;
  
  private float a()
  {
    return this.c;
  }
  
  private float b()
  {
    return this.b;
  }
  
  private float c()
  {
    return this.d;
  }
  
  private float d()
  {
    return this.a;
  }
  
  public void a(@NonNull Matrix paramMatrix, @NonNull Path paramPath)
  {
    Matrix localMatrix = this.g;
    paramMatrix.invert(localMatrix);
    paramPath.transform(localMatrix);
    paramPath.quadTo(d(), b(), a(), c());
    paramPath.transform(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.PathQuadOperation
 * JD-Core Version:    0.7.0.1
 */