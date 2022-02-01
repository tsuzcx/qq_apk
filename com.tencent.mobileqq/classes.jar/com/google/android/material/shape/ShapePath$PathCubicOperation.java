package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;

public class ShapePath$PathCubicOperation
  extends ShapePath.PathOperation
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public void a(@NonNull Matrix paramMatrix, @NonNull Path paramPath)
  {
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    paramMatrix.invert(localMatrix);
    paramPath.transform(localMatrix);
    paramPath.cubicTo(this.jdField_a_of_type_Float, this.b, this.c, this.d, this.e, this.f);
    paramPath.transform(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.PathCubicOperation
 * JD-Core Version:    0.7.0.1
 */