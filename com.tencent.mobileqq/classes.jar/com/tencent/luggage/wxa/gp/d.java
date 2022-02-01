package com.tencent.luggage.wxa.gp;

import com.tencent.luggage.wxa.gw.b;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d
{
  public static boolean a = false;
  
  public static void a()
  {
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
    {
      a = true;
      return;
    }
    a = false;
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, byte[][] paramArrayOfByte1)
  {
    if (paramArrayOfByte1.length <= 1) {
      return;
    }
    int j = paramArrayOfByte.length / 2;
    Arrays.fill(paramArrayOfByte1[0], 0, paramArrayOfByte1[0].length, (byte)0);
    Arrays.fill(paramArrayOfByte1[1], 0, paramArrayOfByte1[1].length, (byte)0);
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        paramInt = 0;
        while (paramInt < j)
        {
          byte[] arrayOfByte = paramArrayOfByte1[0];
          i = paramInt * 2;
          arrayOfByte[paramInt] = paramArrayOfByte[i];
          arrayOfByte = paramArrayOfByte1[0];
          int k = paramInt + 1;
          arrayOfByte[k] = paramArrayOfByte[(i + 1)];
          paramArrayOfByte1[1][paramInt] = paramArrayOfByte[(i + 2)];
          paramArrayOfByte1[1][k] = paramArrayOfByte[(i + 3)];
          paramInt += 2;
        }
      }
    }
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      paramArrayOfByte1[0][i] = paramArrayOfByte[paramInt];
      paramArrayOfByte1[1][i] = paramArrayOfByte[(paramInt + 1)];
      i += 1;
      paramInt += 2;
    }
  }
  
  public static byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (paramInt1 == paramInt2) {
      return paramArrayOfByte;
    }
    if ((paramInt3 != 1) && (paramInt3 != 2) && (paramInt3 != 3)) {
      return paramArrayOfByte;
    }
    int i1 = paramArrayOfByte.length;
    int n = 0;
    int m = 0;
    int k = 0;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return paramArrayOfByte;
      }
      if (paramInt2 != 1) {
        return paramArrayOfByte;
      }
      paramInt2 = i1 / 2;
      arrayOfByte1 = new byte[paramInt2];
      paramInt1 = k;
      if (paramInt3 != 1) {
        if (paramInt3 != 2)
        {
          paramInt1 = k;
          if (paramInt3 != 3) {
            return arrayOfByte1;
          }
        }
        else
        {
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramInt3 = paramInt1 * 2;
            byte[] arrayOfByte2 = a.a(paramArrayOfByte[paramInt3], paramArrayOfByte[(paramInt3 + 1)], paramArrayOfByte[(paramInt3 + 2)], paramArrayOfByte[(paramInt3 + 3)], a);
            arrayOfByte1[paramInt1] = arrayOfByte2[0];
            arrayOfByte1[(paramInt1 + 1)] = arrayOfByte2[1];
            paramInt1 += 2;
          }
        }
      }
      while (paramInt1 < paramInt2)
      {
        paramInt3 = paramInt1 * 2;
        arrayOfByte1[paramInt1] = ((byte)((short)((short)paramArrayOfByte[paramInt3] + (short)paramArrayOfByte[(paramInt3 + 1)]) >> 1));
        paramInt1 += 2;
      }
      return arrayOfByte1;
    }
    if (paramInt2 != 2) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte1 = new byte[i1 * 2];
    paramInt1 = m;
    int i;
    if (paramInt3 != 1)
    {
      paramInt1 = n;
      if (paramInt3 != 2)
      {
        paramInt1 = m;
        if (paramInt3 != 3) {
          return arrayOfByte1;
        }
      }
      else
      {
        while (paramInt1 < i1)
        {
          i = paramArrayOfByte[paramInt1];
          int j = paramArrayOfByte[(paramInt1 + 1)];
          paramInt2 = paramInt1 * 2;
          arrayOfByte1[paramInt2] = i;
          arrayOfByte1[(paramInt2 + 1)] = j;
          arrayOfByte1[(paramInt2 + 2)] = i;
          arrayOfByte1[(paramInt2 + 3)] = j;
          paramInt1 += 2;
        }
      }
    }
    while (paramInt1 < i1)
    {
      i = paramArrayOfByte[paramInt1];
      paramInt2 = paramInt1 * 2;
      arrayOfByte1[paramInt2] = i;
      arrayOfByte1[(paramInt2 + 1)] = i;
      paramInt1 += 1;
    }
    return arrayOfByte1;
  }
  
  public static byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfByte;
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return paramArrayOfByte;
        }
      }
      else
      {
        if ((paramInt2 != 1) && (paramInt2 != 3)) {
          return paramArrayOfByte;
        }
        paramInt2 = j / 2;
        arrayOfByte1 = new byte[paramInt2];
        paramInt1 = i;
        while (paramInt1 < paramInt2)
        {
          i = paramInt1 * 2;
          arrayOfByte1[paramInt1] = ((byte)(a.a(paramArrayOfByte[i], paramArrayOfByte[(i + 1)], a) / 256));
          paramInt1 += 1;
        }
        return arrayOfByte1;
      }
    }
    if (paramInt2 != 2) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte1 = new byte[j * 2];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      byte[] arrayOfByte2 = a.a((short)(paramArrayOfByte[paramInt1] * 256), a);
      paramInt2 = paramInt1 * 2;
      arrayOfByte1[paramInt2] = arrayOfByte2[0];
      arrayOfByte1[(paramInt2 + 1)] = arrayOfByte2[1];
      paramInt1 += 1;
    }
    return arrayOfByte1;
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2.length != 0))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      {
        b.a("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
        return null;
      }
      int m = paramArrayOfByte1.length;
      byte[] arrayOfByte = new byte[m * 2];
      int j = 0;
      int k = 0;
      int i = j;
      if (paramInt != 1)
      {
        i = k;
        if (paramInt != 2)
        {
          i = j;
          if (paramInt != 3) {
            return arrayOfByte;
          }
        }
        else
        {
          while (i < m)
          {
            paramInt = i * 2;
            arrayOfByte[paramInt] = paramArrayOfByte1[i];
            j = i + 1;
            arrayOfByte[(paramInt + 1)] = paramArrayOfByte1[j];
            arrayOfByte[(paramInt + 2)] = paramArrayOfByte2[i];
            arrayOfByte[(paramInt + 3)] = paramArrayOfByte2[j];
            i += 2;
          }
        }
      }
      while (i < m)
      {
        arrayOfByte[i] = paramArrayOfByte1[i];
        arrayOfByte[(i + 1)] = paramArrayOfByte2[i];
        i += 2;
      }
      return arrayOfByte;
    }
    b.a("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.d
 * JD-Core Version:    0.7.0.1
 */