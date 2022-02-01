package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator
  implements TypeEvaluator<float[]>
{
  private float[] mArray;
  
  FloatArrayEvaluator(float[] paramArrayOfFloat)
  {
    this.mArray = paramArrayOfFloat;
  }
  
  public float[] evaluate(float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat2 = this.mArray;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null) {
      arrayOfFloat1 = new float[paramArrayOfFloat1.length];
    }
    int i = 0;
    while (i < arrayOfFloat1.length)
    {
      float f = paramArrayOfFloat1[i];
      arrayOfFloat1[i] = (f + (paramArrayOfFloat2[i] - f) * paramFloat);
      i += 1;
    }
    return arrayOfFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.FloatArrayEvaluator
 * JD-Core Version:    0.7.0.1
 */