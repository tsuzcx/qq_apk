package com.tencent.comic;

import java.lang.reflect.Array;

public class PluginPreloadStrategy$KMeans
{
  private int jdField_a_of_type_Int = 3;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float[][] jdField_a_of_type_Array2dOfFloat;
  
  public PluginPreloadStrategy$KMeans(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Array2dOfFloat = ((float[][])Array.newInstance(Float.TYPE, new int[] { this.jdField_a_of_type_Int, 2 }));
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_Int)
    {
      float[][] arrayOfFloat = this.jdField_a_of_type_Array2dOfFloat;
      arrayOfFloat[paramInt][0] = 0;
      arrayOfFloat[paramInt][1] = 0;
      paramInt += 1;
    }
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = this.jdField_a_of_type_Int;
      if ((j >= i) && (i > 0) && (paramInt >= 1))
      {
        if (paramInt > paramArrayOfInt.length) {
          return -1;
        }
        int i2 = paramArrayOfInt.length;
        this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
        int m = i2 / i;
        int k;
        for (i = 0; i < this.jdField_a_of_type_Int; i = k)
        {
          j = i * m;
          paramArrayOfInt = this.jdField_a_of_type_Array2dOfFloat;
          paramArrayOfInt[i][0] = j;
          paramArrayOfInt[i][1] = this.jdField_a_of_type_ArrayOfInt[j];
          for (;;)
          {
            k = i + 1;
            if ((j >= k * m) || (j >= i2)) {
              break;
            }
            paramArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
            float f = paramArrayOfInt[j];
            localObject1 = this.jdField_a_of_type_Array2dOfFloat;
            if (f > localObject1[i][1])
            {
              localObject1[i][0] = j;
              localObject1[i][1] = paramArrayOfInt[j];
            }
            j += 1;
          }
        }
        paramArrayOfInt = new int[i2];
        i = 0;
        while (i < i2)
        {
          paramArrayOfInt[i] = -1;
          i += 1;
        }
        Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.jdField_a_of_type_Int, 2 });
        int[] arrayOfInt = new int[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          localObject1[i][0] = 0;
          localObject1[i][1] = 0;
          arrayOfInt[i] = ((int)this.jdField_a_of_type_Array2dOfFloat[i][0]);
          i += 1;
        }
        j = 0;
        i = 0;
        while ((j < 10) && (i == 0))
        {
          k = 0;
          int n;
          while (k < i2)
          {
            if (this.jdField_a_of_type_ArrayOfInt[k] != 0)
            {
              m = Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[0][0]);
              i = 0;
              int i1 = 0;
              while (i < this.jdField_a_of_type_Int)
              {
                n = m;
                if (m > Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[i][0]))
                {
                  n = Math.abs(k - (int)this.jdField_a_of_type_Array2dOfFloat[i][0]);
                  i1 = i;
                }
                i += 1;
                m = n;
              }
              paramArrayOfInt[k] = i1;
            }
            k += 1;
          }
          i = 0;
          while (i < this.jdField_a_of_type_Int)
          {
            localObject1[i][0] = 0;
            localObject1[i][1] = 0;
            i += 1;
          }
          i = 0;
          Object localObject2;
          while (i < i2)
          {
            localObject2 = this.jdField_a_of_type_ArrayOfInt;
            if (localObject2[i] != 0)
            {
              Object localObject3 = localObject1[paramArrayOfInt[i]];
              localObject3[0] += localObject2[i] * i;
              localObject3 = localObject1[paramArrayOfInt[i]];
              localObject3[1] += localObject2[i];
            }
            i += 1;
          }
          i = 0;
          while (i < this.jdField_a_of_type_Int)
          {
            if (localObject1[i][1] != 0)
            {
              localObject2 = this.jdField_a_of_type_Array2dOfFloat[i];
              double d1 = localObject1[i][0];
              Double.isNaN(d1);
              double d2 = localObject1[i][1];
              Double.isNaN(d2);
              localObject2[0] = ((int)Math.round(d1 * 1.0D / d2));
              m = (int)this.jdField_a_of_type_Array2dOfFloat[i][0] - paramInt / 2;
              if (m < 0) {
                k = i2;
              } else {
                k = 0;
              }
              localObject1[i][1] = 0;
              m += k;
              k = 0;
              while (k < paramInt)
              {
                if (paramArrayOfInt[m] == i)
                {
                  localObject2 = localObject1[i];
                  localObject2[1] += this.jdField_a_of_type_ArrayOfInt[m];
                }
                n = m + 1;
                if (n >= i2) {
                  m = -i2;
                } else {
                  m = 0;
                }
                m = n + m;
                k += 1;
              }
              this.jdField_a_of_type_Array2dOfFloat[i][1] = localObject1[i][1];
            }
            i += 1;
          }
          k = 0;
          i = 1;
          while (k < this.jdField_a_of_type_Int)
          {
            m = arrayOfInt[k];
            localObject2 = this.jdField_a_of_type_Array2dOfFloat;
            if (m != (int)localObject2[k][0])
            {
              arrayOfInt[k] = ((int)localObject2[k][0]);
              i = 0;
            }
            k += 1;
          }
          j += 1;
        }
        paramInt = 0;
        for (;;)
        {
          paramArrayOfInt = this.jdField_a_of_type_Array2dOfFloat;
          if (paramInt >= paramArrayOfInt.length) {
            break;
          }
          for (i = 0;; i = j)
          {
            paramArrayOfInt = this.jdField_a_of_type_Array2dOfFloat;
            if (i >= paramArrayOfInt.length - paramInt - 1) {
              break;
            }
            j = i + 1;
            if (paramArrayOfInt[j][1] > paramArrayOfInt[i][1])
            {
              k = paramArrayOfInt[i][0];
              m = paramArrayOfInt[i][1];
              paramArrayOfInt[i][0] = paramArrayOfInt[j][0];
              paramArrayOfInt[i][1] = paramArrayOfInt[j][1];
              paramArrayOfInt[j][0] = k;
              paramArrayOfInt[j][1] = m;
            }
          }
          paramInt += 1;
        }
        return (int)paramArrayOfInt[0][0];
      }
    }
    return -1;
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramInt > 0) && (paramArrayOfInt.length >= paramInt))
    {
      int i = 0;
      int j = 0;
      while (i < paramInt)
      {
        j += paramArrayOfInt[i];
        i += 1;
      }
      int k = j;
      int n = 1;
      i = 0;
      int m = j;
      j = n;
      while (j < paramArrayOfInt.length)
      {
        int i1 = paramArrayOfInt[(j - 1)];
        n = j + paramInt - 1;
        if (n < paramArrayOfInt.length) {
          n = paramArrayOfInt[n];
        } else {
          n = paramArrayOfInt[(n % paramArrayOfInt.length)];
        }
        m = m - i1 + n;
        n = k;
        if (k < m)
        {
          i = j;
          n = m;
        }
        j += 1;
        k = n;
      }
      int[] arrayOfInt = new int[paramInt];
      k = 0;
      j = i;
      i = k;
      while (i < paramInt)
      {
        arrayOfInt[i] = j;
        k = j + 1;
        if (k >= paramArrayOfInt.length) {
          j = -paramArrayOfInt.length;
        } else {
          j = 0;
        }
        j = k + j;
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.PluginPreloadStrategy.KMeans
 * JD-Core Version:    0.7.0.1
 */