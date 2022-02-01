package com.tencent.biz.subscribe.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

class TransitionAnimHelper$MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  public static TypeEvaluator<Matrix> a;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float[] b = new float[9];
  
  static
  {
    jdField_a_of_type_AndroidAnimationTypeEvaluator = new TransitionAnimHelper.MatrixEvaluator.1();
  }
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.MatrixEvaluator
 * JD-Core Version:    0.7.0.1
 */