package androidx.constraintlayout.motion.widget;

class KeyCycleOscillator$IntFloatFloatSort
{
  private static int partition(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2)
  {
    int k = paramArrayOfInt[paramInt2];
    int j;
    for (int i = paramInt1; paramInt1 < paramInt2; i = j)
    {
      j = i;
      if (paramArrayOfInt[paramInt1] <= k)
      {
        swap(paramArrayOfInt, paramArrayOfFloat1, paramArrayOfFloat2, i, paramInt1);
        j = i + 1;
      }
      paramInt1 += 1;
    }
    swap(paramArrayOfInt, paramArrayOfFloat1, paramArrayOfFloat2, i, paramInt2);
    return i;
  }
  
  static void sort(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length + 10];
    arrayOfInt[0] = paramInt2;
    arrayOfInt[1] = paramInt1;
    paramInt1 = 2;
    while (paramInt1 > 0)
    {
      paramInt1 -= 1;
      int i = arrayOfInt[paramInt1];
      paramInt2 = paramInt1 - 1;
      int j = arrayOfInt[paramInt2];
      paramInt1 = paramInt2;
      if (i < j)
      {
        int k = partition(paramArrayOfInt, paramArrayOfFloat1, paramArrayOfFloat2, i, j);
        paramInt1 = paramInt2 + 1;
        arrayOfInt[paramInt2] = (k - 1);
        paramInt2 = paramInt1 + 1;
        arrayOfInt[paramInt1] = i;
        i = paramInt2 + 1;
        arrayOfInt[paramInt2] = j;
        paramInt1 = i + 1;
        arrayOfInt[i] = (k + 1);
      }
    }
  }
  
  private static void swap(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt[paramInt1];
    paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = i;
    float f = paramArrayOfFloat1[paramInt1];
    paramArrayOfFloat1[paramInt1] = paramArrayOfFloat1[paramInt2];
    paramArrayOfFloat1[paramInt2] = f;
    f = paramArrayOfFloat2[paramInt1];
    paramArrayOfFloat2[paramInt1] = paramArrayOfFloat2[paramInt2];
    paramArrayOfFloat2[paramInt2] = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycleOscillator.IntFloatFloatSort
 * JD-Core Version:    0.7.0.1
 */