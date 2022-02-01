package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private final float[] b = new float[9];
  
  @NonNull
  public Matrix a(float paramFloat, @NonNull Matrix paramMatrix1, @NonNull Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.jdField_a_of_type_ArrayOfFloat);
    paramMatrix2.getValues(this.b);
    int i = 0;
    while (i < 9)
    {
      paramMatrix1 = this.b;
      float f1 = paramMatrix1[i];
      paramMatrix2 = this.jdField_a_of_type_ArrayOfFloat;
      float f2 = paramMatrix2[i];
      paramMatrix2[i] += (f1 - f2) * paramFloat;
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.b);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.animation.MatrixEvaluator
 * JD-Core Version:    0.7.0.1
 */