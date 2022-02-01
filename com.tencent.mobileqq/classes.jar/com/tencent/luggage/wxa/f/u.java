package com.tencent.luggage.wxa.f;

public class u
{
  private static byte[] a;
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = a;
    if (arrayOfByte == null)
    {
      a = new byte[paramInt1 * paramInt2 * 3 >> 1];
    }
    else
    {
      i = arrayOfByte.length;
      j = paramInt1 * paramInt2 * 3 >> 1;
      if (i != j) {
        a = new byte[j];
      }
    }
    int i = 0;
    int j = 0;
    int k;
    while (i < paramInt1)
    {
      k = paramInt2 - 1;
      while (k >= 0)
      {
        a[j] = paramArrayOfByte[(k * paramInt1 + i)];
        k -= 1;
        j += 1;
      }
      i += 1;
    }
    int m = paramInt1 * paramInt2;
    i = (m * 3 >> 1) - 1;
    j = paramInt1 - 1;
    while (j > 0)
    {
      k = 0;
      while (k < paramInt2 >> 1)
      {
        arrayOfByte = a;
        int n = i - 1;
        int i1 = k * paramInt1 + m;
        arrayOfByte[i] = paramArrayOfByte[(i1 + j)];
        i = n - 1;
        arrayOfByte[n] = paramArrayOfByte[(i1 + (j - 1))];
        k += 1;
      }
      j -= 2;
    }
    return a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramInt3 != 0) {
      if (paramInt3 != 90) {
        if (paramInt3 != 180) {
          if (paramInt3 != 270) {
            return paramArrayOfByte;
          }
        }
      }
    }
    try
    {
      return c(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      break label52;
    }
    return b(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2);
    return paramArrayOfByte;
    label52:
    f.c("YUV420Helper", "rotate frame data fail because of OOM");
    arrayOfByte = null;
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f3 = paramInt3 * 1.0F / paramInt1;
    byte[] arrayOfByte = new byte[paramInt3 * paramInt4 * 4];
    int n = 0;
    float f1 = 0.0F;
    int i = 0;
    while (n < paramInt2)
    {
      f1 += f3;
      double d1 = f1;
      if (Math.floor(d1) == paramInt4) {
        return arrayOfByte;
      }
      if ((Math.floor(f1 - f3) == Math.floor(d1)) && ((n != paramInt2 - 1) || (Math.floor(d1) >= paramInt2))) {
        break label485;
      }
      int i1 = 0;
      float f2 = 0.0F;
      while (i1 < paramInt1)
      {
        f2 += f3;
        d1 = f2;
        double d2 = Math.floor(d1);
        double d3 = paramInt3;
        if (d2 == d3) {
          break;
        }
        if ((Math.floor(f2 - f3) == Math.floor(d1)) && ((i1 != paramInt1 - 1) || (Math.floor(d1) >= d3))) {
          break label476;
        }
        int j = paramArrayOfByte[(n * paramInt1 + i1)];
        int m = 255;
        int i2 = i1 / 2;
        int k = n / 2;
        i2 = i2 * 2 + paramInt1 * paramInt2;
        k *= paramInt1;
        float f4 = (paramArrayOfByte[(i2 + k)] & 0xFF) - 128.0F;
        float f5 = (paramArrayOfByte[(i2 + 1 + k)] & 0xFF) - 128.0F;
        float f6 = (j & 0xFF) * 1.164F - 16.0F;
        k = (int)(1.596F * f4 + f6);
        int i3 = (int)(f6 - f4 * 0.813F - 0.391F * f5);
        i2 = (int)(f6 + f5 * 2.018F);
        if (k < 0)
        {
          j = 0;
        }
        else
        {
          j = k;
          if (k > 255) {
            j = 255;
          }
        }
        if (i3 < 0)
        {
          k = 0;
        }
        else
        {
          k = i3;
          if (i3 > 255) {
            k = 255;
          }
        }
        if (i2 < 0) {
          m = 0;
        } else if (i2 <= 255) {
          m = i2;
        }
        if (i > arrayOfByte.length - 5) {
          return arrayOfByte;
        }
        i2 = i + 1;
        arrayOfByte[i] = ((byte)j);
        i = i2 + 1;
        arrayOfByte[i2] = ((byte)k);
        j = i + 1;
        arrayOfByte[i] = ((byte)m);
        i = j + 1;
        arrayOfByte[j] = -1;
        label476:
        i1 += 1;
      }
      label485:
      n += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = a;
    if (arrayOfByte == null)
    {
      a = new byte[paramInt1 * paramInt2 * 3 >> 1];
    }
    else
    {
      i = arrayOfByte.length;
      j = paramInt1 * paramInt2 * 3 >> 1;
      if (i != j) {
        a = new byte[j];
      }
    }
    int i = 0;
    int j = paramInt1 * paramInt2;
    paramInt2 = j - 1;
    paramInt1 = i;
    while (paramInt2 >= 0)
    {
      a[paramInt1] = paramArrayOfByte[paramInt2];
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    paramInt2 = (j * 3 >> 1) - 1;
    while (paramInt2 >= j)
    {
      arrayOfByte = a;
      i = paramInt1 + 1;
      arrayOfByte[paramInt1] = paramArrayOfByte[(paramInt2 - 1)];
      paramInt1 = i + 1;
      arrayOfByte[i] = paramArrayOfByte[paramInt2];
      paramInt2 -= 2;
    }
    return a;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = a;
    if (arrayOfByte == null)
    {
      a = new byte[paramInt1 * paramInt2 * 3 >> 1];
    }
    else
    {
      i = arrayOfByte.length;
      j = paramInt1 * paramInt2 * 3 >> 1;
      if (i != j) {
        a = new byte[j];
      }
    }
    int j = paramInt1 - 1;
    int k = j;
    int i = 0;
    while (k >= 0)
    {
      m = 0;
      while (m < paramInt2)
      {
        a[i] = paramArrayOfByte[(m * paramInt1 + k)];
        m += 1;
        i += 1;
      }
      k -= 1;
    }
    int m = paramInt1 * paramInt2;
    i = m;
    while (j > 0)
    {
      k = 0;
      while (k < paramInt2 >> 1)
      {
        arrayOfByte = a;
        int n = i + 1;
        int i1 = k * paramInt1 + m;
        arrayOfByte[i] = paramArrayOfByte[(j - 1 + i1)];
        i = n + 1;
        arrayOfByte[n] = paramArrayOfByte[(i1 + j)];
        k += 1;
      }
      j -= 2;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.u
 * JD-Core Version:    0.7.0.1
 */