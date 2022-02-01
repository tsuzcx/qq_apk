package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

public class ShapePath$PathLineOperation
  extends ShapePath.PathOperation
{
  private float a;
  private float b;
  
  public void a(@NonNull Matrix paramMatrix, @NonNull Path paramPath)
  {
    Matrix localMatrix = this.g;
    paramMatrix.invert(localMatrix);
    paramPath.transform(localMatrix);
    paramPath.lineTo(this.a, this.b);
    paramPath.transform(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.PathLineOperation
 * JD-Core Version:    0.7.0.1
 */