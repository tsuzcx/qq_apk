package com.google.zxing.qrcode.encoder;

final class MaskUtil
{
  static int a(ByteMatrix paramByteMatrix)
  {
    return a(paramByteMatrix, true) + a(paramByteMatrix, false);
  }
  
  private static int a(ByteMatrix paramByteMatrix, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = paramByteMatrix.a();
    } else {
      m = paramByteMatrix.b();
    }
    int n;
    if (paramBoolean) {
      n = paramByteMatrix.b();
    } else {
      n = paramByteMatrix.a();
    }
    paramByteMatrix = paramByteMatrix.c();
    int i1 = 0;
    int i = 0;
    while (i1 < m)
    {
      int i2 = 0;
      int i3 = 0;
      int i4;
      for (int k = -1; i2 < n; k = i4)
      {
        if (paramBoolean) {
          j = paramByteMatrix[i1][i2];
        } else {
          j = paramByteMatrix[i2][i1];
        }
        if (j == k)
        {
          j = i3 + 1;
          i4 = k;
        }
        else
        {
          k = i;
          if (i3 >= 5) {
            k = i + (i3 - 5 + 3);
          }
          i3 = 1;
          i4 = j;
          i = k;
          j = i3;
        }
        i2 += 1;
        i3 = j;
      }
      int j = i;
      if (i3 > 5) {
        j = i + (i3 - 5 + 3);
      }
      i = j;
      i1 += 1;
    }
    return i;
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    switch (paramInt1)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mask pattern: ");
      localStringBuilder.append(paramInt1);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 7: 
      paramInt1 = paramInt3 * paramInt2 % 3;
      paramInt2 = paramInt3 + paramInt2 & 0x1;
      break;
    case 6: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      break;
    case 5: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      break;
    case 4: 
      paramInt1 = paramInt3 >>> 1;
      paramInt2 /= 3;
      paramInt1 += paramInt2;
      paramInt1 &= 0x1;
      break;
    case 3: 
      paramInt1 = (paramInt3 + paramInt2) % 3;
      break;
    case 2: 
      paramInt1 = paramInt2 % 3;
      break;
    case 0: 
      i = paramInt3 + paramInt2;
    }
    paramInt1 = i & 0x1;
    return paramInt1 == 0;
  }
  
  static int b(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.c();
    int i1 = paramByteMatrix.b();
    int i2 = paramByteMatrix.a();
    int j = 0;
    int i = 0;
    while (j < i2 - 1)
    {
      int m = 0;
      while (m < i1 - 1)
      {
        int i3 = arrayOfByte[j][m];
        paramByteMatrix = arrayOfByte[j];
        int n = m + 1;
        int k = i;
        if (i3 == paramByteMatrix[n])
        {
          int i4 = j + 1;
          k = i;
          if (i3 == arrayOfByte[i4][m])
          {
            k = i;
            if (i3 == arrayOfByte[i4][n]) {
              k = i + 1;
            }
          }
        }
        m = n;
        i = k;
      }
      j += 1;
    }
    return i * 3;
  }
  
  static int c(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.c();
    int n = paramByteMatrix.b();
    int i1 = paramByteMatrix.a();
    int k = 0;
    int i = 0;
    while (k < i1)
    {
      int m = 0;
      while (m < n)
      {
        int i2 = m + 6;
        int j = i;
        if (i2 < n)
        {
          j = i;
          if (arrayOfByte[k][m] == 1)
          {
            j = i;
            if (arrayOfByte[k][(m + 1)] == 0)
            {
              j = i;
              if (arrayOfByte[k][(m + 2)] == 1)
              {
                j = i;
                if (arrayOfByte[k][(m + 3)] == 1)
                {
                  j = i;
                  if (arrayOfByte[k][(m + 4)] == 1)
                  {
                    j = i;
                    if (arrayOfByte[k][(m + 5)] == 0)
                    {
                      j = i;
                      if (arrayOfByte[k][i2] == 1)
                      {
                        j = m + 10;
                        if ((j >= n) || (arrayOfByte[k][(m + 7)] != 0) || (arrayOfByte[k][(m + 8)] != 0) || (arrayOfByte[k][(m + 9)] != 0) || (arrayOfByte[k][j] != 0))
                        {
                          i2 = m - 4;
                          j = i;
                          if (i2 >= 0)
                          {
                            j = i;
                            if (arrayOfByte[k][(m - 1)] == 0)
                            {
                              j = i;
                              if (arrayOfByte[k][(m - 2)] == 0)
                              {
                                j = i;
                                if (arrayOfByte[k][(m - 3)] == 0)
                                {
                                  j = i;
                                  if (arrayOfByte[k][i2] != 0) {}
                                }
                              }
                            }
                          }
                        }
                        else
                        {
                          j = i + 40;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i2 = k + 6;
        i = j;
        if (i2 < i1)
        {
          i = j;
          if (arrayOfByte[k][m] == 1)
          {
            i = j;
            if (arrayOfByte[(k + 1)][m] == 0)
            {
              i = j;
              if (arrayOfByte[(k + 2)][m] == 1)
              {
                i = j;
                if (arrayOfByte[(k + 3)][m] == 1)
                {
                  i = j;
                  if (arrayOfByte[(k + 4)][m] == 1)
                  {
                    i = j;
                    if (arrayOfByte[(k + 5)][m] == 0)
                    {
                      i = j;
                      if (arrayOfByte[i2][m] == 1)
                      {
                        i = k + 10;
                        if ((i >= i1) || (arrayOfByte[(k + 7)][m] != 0) || (arrayOfByte[(k + 8)][m] != 0) || (arrayOfByte[(k + 9)][m] != 0) || (arrayOfByte[i][m] != 0))
                        {
                          i2 = k - 4;
                          i = j;
                          if (i2 >= 0)
                          {
                            i = j;
                            if (arrayOfByte[(k - 1)][m] == 0)
                            {
                              i = j;
                              if (arrayOfByte[(k - 2)][m] == 0)
                              {
                                i = j;
                                if (arrayOfByte[(k - 3)][m] == 0)
                                {
                                  i = j;
                                  if (arrayOfByte[i2][m] != 0) {}
                                }
                              }
                            }
                          }
                        }
                        else
                        {
                          i = j + 40;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        m += 1;
      }
      k += 1;
    }
    return i;
  }
  
  static int d(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.c();
    int n = paramByteMatrix.b();
    int i1 = paramByteMatrix.a();
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      byte[] arrayOfByte1 = arrayOfByte[j];
      k = 0;
      while (k < n)
      {
        int m = i;
        if (arrayOfByte1[k] == 1) {
          m = i + 1;
        }
        k += 1;
        i = m;
      }
      j += 1;
    }
    j = paramByteMatrix.a();
    int k = paramByteMatrix.b();
    double d1 = i;
    double d2 = j * k;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (int)(Math.abs(d1 / d2 - 0.5D) * 20.0D) * 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.MaskUtil
 * JD-Core Version:    0.7.0.1
 */