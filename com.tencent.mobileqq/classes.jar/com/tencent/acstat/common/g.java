package com.tencent.acstat.common;

class g
  extends f
{
  private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int e;
  private int f;
  private final int[] g;
  
  public g(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = c;
    } else {
      paramArrayOfByte = d;
    }
    this.g = paramArrayOfByte;
    this.e = 0;
    this.f = 0;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.e;
    if (j == 6) {
      return false;
    }
    int i1 = paramInt2 + paramInt1;
    int i = this.f;
    byte[] arrayOfByte = this.a;
    int[] arrayOfInt = this.g;
    paramInt2 = 0;
    int m;
    int k;
    for (;;)
    {
      m = i;
      k = paramInt2;
      if (paramInt1 >= i1) {
        break;
      }
      int n = paramInt1;
      k = i;
      m = paramInt2;
      if (j == 0)
      {
        k = i;
        for (i = paramInt1;; i = m)
        {
          m = i + 4;
          paramInt1 = k;
          if (m > i1) {
            break;
          }
          paramInt1 = arrayOfInt[(paramArrayOfByte[i] & 0xFF)];
          k = arrayOfInt[(paramArrayOfByte[(i + 1)] & 0xFF)];
          n = arrayOfInt[(paramArrayOfByte[(i + 2)] & 0xFF)];
          k = arrayOfInt[(paramArrayOfByte[(i + 3)] & 0xFF)] | k << 12 | paramInt1 << 18 | n << 6;
          paramInt1 = k;
          if (k < 0) {
            break;
          }
          arrayOfByte[(paramInt2 + 2)] = ((byte)k);
          arrayOfByte[(paramInt2 + 1)] = ((byte)(k >> 8));
          arrayOfByte[paramInt2] = ((byte)(k >> 16));
          paramInt2 += 3;
        }
        m = paramInt1;
        k = paramInt2;
        if (i >= i1) {
          break;
        }
        m = paramInt2;
        k = paramInt1;
        n = i;
      }
      paramInt1 = n + 1;
      paramInt2 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2) {
            if (j != 3) {
              if (j != 4)
              {
                if (j != 5)
                {
                  i = k;
                  break label585;
                }
                i = k;
                if (paramInt2 == -1) {
                  break label585;
                }
              }
            }
          }
          for (;;)
          {
            this.e = 6;
            return false;
            if (paramInt2 == -2)
            {
              i = k;
              break label526;
            }
            i = k;
            if (paramInt2 == -1) {
              break label585;
            }
            this.e = 6;
            return false;
            if (paramInt2 >= 0)
            {
              i = k << 6 | paramInt2;
              arrayOfByte[(m + 2)] = ((byte)i);
              arrayOfByte[(m + 1)] = ((byte)(i >> 8));
              arrayOfByte[m] = ((byte)(i >> 16));
              paramInt2 = m + 3;
              j = 0;
              break;
            }
            if (paramInt2 == -2)
            {
              arrayOfByte[(m + 1)] = ((byte)(k >> 2));
              arrayOfByte[m] = ((byte)(k >> 10));
              paramInt2 = m + 2;
              j = 5;
              i = k;
              break;
            }
            i = k;
            if (paramInt2 == -1) {
              break label585;
            }
            this.e = 6;
            return false;
            if (paramInt2 >= 0) {
              break label517;
            }
            if (paramInt2 == -2)
            {
              arrayOfByte[m] = ((byte)(k >> 4));
              paramInt2 = m + 1;
              j = 4;
              i = k;
              break;
            }
            i = k;
            if (paramInt2 == -1) {
              break label585;
            }
          }
        }
        else if (paramInt2 >= 0)
        {
          label517:
          i = k << 6 | paramInt2;
          label526:
          j += 1;
        }
        else
        {
          i = k;
          if (paramInt2 != -1)
          {
            this.e = 6;
            return false;
          }
        }
      }
      else if (paramInt2 >= 0)
      {
        j += 1;
        i = paramInt2;
      }
      else
      {
        i = k;
        if (paramInt2 != -1)
        {
          this.e = 6;
          return false;
        }
      }
      label585:
      paramInt2 = m;
    }
    if (!paramBoolean)
    {
      this.e = j;
      this.f = m;
      paramInt1 = k;
    }
    for (;;)
    {
      this.b = paramInt1;
      return true;
      paramInt1 = k;
      if (j != 0)
      {
        if (j == 1) {
          break;
        }
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              break;
            }
            paramInt1 = k;
            break label703;
          }
          paramInt2 = k + 1;
          arrayOfByte[k] = ((byte)(m >> 10));
          paramInt1 = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(m >> 2));
          break label703;
        }
        arrayOfByte[k] = ((byte)(m >> 4));
        paramInt1 = k + 1;
      }
      label703:
      this.e = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.g
 * JD-Core Version:    0.7.0.1
 */