package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

class TransitionUtils$MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  final float[] mTempEndValues = new float[9];
  final Matrix mTempMatrix = new Matrix();
  final float[] mTempStartValues = new float[9];
  
  public Matrix evaluate(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.mTempStartValues);
    paramMatrix2.getValues(this.mTempEndValues);
    int i = 0;
    while (i < 9)
    {
      paramMatrix1 = this.mTempEndValues;
      float f1 = paramMatrix1[i];
      paramMatrix2 = this.mTempStartValues;
      float f2 = paramMatrix2[i];
      paramMatrix2[i] += (f1 - f2) * paramFloat;
      i += 1;
    }
    this.mTempMatrix.setValues(this.mTempEndValues);
    return this.mTempMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.TransitionUtils.MatrixEvaluator
 * JD-Core Version:    0.7.0.1
 */