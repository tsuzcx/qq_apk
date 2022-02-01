package com.tencent.acstat.common;

public class e
{
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    g localg = new g(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localg.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localg.b == localg.a.length) {
        return localg.a;
      }
      paramArrayOfByte = new byte[localg.b];
      System.arraycopy(localg.a, 0, paramArrayOfByte, 0, localg.b);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    h localh = new h(paramInt3, null);
    paramInt3 = paramInt2 / 3;
    int j = 2;
    int i = paramInt3 << 2;
    int k;
    if (localh.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      k = paramInt2 % 3;
      paramInt3 = i;
      if (k != 0) {
        if (k != 1)
        {
          if (k != 2) {
            paramInt3 = i;
          } else {
            paramInt3 = i + 3;
          }
        }
        else {
          paramInt3 = i + 2;
        }
      }
    }
    i = paramInt3;
    if (localh.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        k = (paramInt2 - 1) / 57;
        if (localh.f) {
          i = j;
        } else {
          i = 1;
        }
        i = paramInt3 + (k + 1) * i;
      }
    }
    localh.a = new byte[i];
    localh.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!a) && (localh.b != i)) {
      throw new AssertionError();
    }
    return localh.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.e
 * JD-Core Version:    0.7.0.1
 */