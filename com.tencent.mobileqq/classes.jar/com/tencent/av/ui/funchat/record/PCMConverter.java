package com.tencent.av.ui.funchat.record;

import com.tencent.qphone.base.util.QLog;

public class PCMConverter
{
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramInt1 == paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PCMConverter", 2, "converteBitCount, srcBitCount == targetBitCount");
        }
        return paramArrayOfByte;
      }
      int i = 0;
      byte[] arrayOfByte;
      if ((paramInt1 == 8) && (paramInt2 == 16))
      {
        arrayOfByte = new byte[paramArrayOfByte.length * 2];
        paramInt1 = i;
        while (paramInt1 < paramArrayOfByte.length)
        {
          paramInt2 = (short)(paramArrayOfByte[paramInt1] * 256);
          i = paramInt1 * 2;
          arrayOfByte[(i + 1)] = ((byte)(paramInt2 & 0xFF));
          arrayOfByte[i] = ((byte)((short)(paramInt2 >> 8) & 0xFF));
          paramInt1 += 1;
        }
        return arrayOfByte;
      }
      if ((paramInt1 == 16) && (paramInt2 == 8))
      {
        arrayOfByte = new byte[paramArrayOfByte.length / 2];
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length / 2)
        {
          paramInt2 = paramInt1 * 2;
          i = (short)((short)((short)paramArrayOfByte[(paramInt2 + 1)] & 0xFF | 0x0) << 8);
          arrayOfByte[paramInt1] = ((byte)((short)((short)paramArrayOfByte[paramInt2] & 0xFF | i) / 256));
          paramInt1 += 1;
        }
        return arrayOfByte;
      }
      return paramArrayOfByte;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PCMConverter", 2, "converteBitCount, srcData == null || srcData.length == 0");
    }
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1 / 8;
    int i2 = paramArrayOfByte.length / i1;
    Object localObject = new short[i2];
    int n = 0;
    int m = 0;
    int j = 0;
    paramInt1 = 0;
    while (j < i2)
    {
      int k = 0;
      int i = 0;
      while (k < i1)
      {
        i = (short)(i | (short)((paramArrayOfByte[paramInt1] & 0xFF) << k * 8));
        k += 1;
        paramInt1 += 1;
      }
      localObject[j] = i;
      j += 1;
    }
    short[] arrayOfShort = a(paramInt2, paramInt3, (short[])localObject);
    paramInt2 = arrayOfShort.length;
    if (i1 == 1)
    {
      localObject = new byte[paramInt2];
      paramInt1 = m;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt1 >= paramInt2) {
          break;
        }
        localObject[paramInt1] = ((byte)arrayOfShort[paramInt1]);
        paramInt1 += 1;
      }
    }
    localObject = new byte[paramInt2 * 2];
    paramInt1 = n;
    for (;;)
    {
      paramArrayOfByte = (byte[])localObject;
      if (paramInt1 >= arrayOfShort.length) {
        break;
      }
      paramInt2 = paramInt1 * 2;
      localObject[paramInt2] = ((byte)(arrayOfShort[paramInt1] & 0xFF));
      localObject[(paramInt2 + 1)] = ((byte)(arrayOfShort[paramInt1] >> 8 & 0xFF));
      paramInt1 += 1;
    }
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramInt2 != paramInt5) {
      arrayOfByte = a(paramArrayOfByte, paramInt2, paramInt5);
    }
    paramArrayOfByte = arrayOfByte;
    if (paramInt3 != paramInt6) {
      paramArrayOfByte = b(arrayOfByte, paramInt3, paramInt6, paramInt5);
    }
    arrayOfByte = paramArrayOfByte;
    if (paramInt1 != paramInt4) {
      arrayOfByte = a(paramArrayOfByte, paramInt5, paramInt1, paramInt4);
    }
    return arrayOfByte;
  }
  
  public static short[] a(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfShort;
    }
    int j = Math.round(paramArrayOfShort.length / paramInt1 * paramInt2);
    float f1 = j / paramArrayOfShort.length;
    short[] arrayOfShort = new short[j];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      float f2 = paramInt1 / f1;
      int k = (int)f2;
      int i = k + 1;
      paramInt2 = i;
      if (i >= paramArrayOfShort.length) {
        paramInt2 = paramArrayOfShort.length - 1;
      }
      arrayOfShort[paramInt1] = ((short)(int)((paramArrayOfShort[paramInt2] - paramArrayOfShort[k]) * (f2 - k) + paramArrayOfShort[k]));
      paramInt1 += 1;
    }
    return arrayOfShort;
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (paramInt1 == paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PCMConverter", 2, "convertChannelCount, srcChannelCount == targetChannelCount");
        }
        return paramArrayOfByte;
      }
      if ((paramInt3 != 8) && (paramInt3 != 16))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PCMConverter", 2, "convertChannelCount, only support bit8 and bit16");
        }
        return paramArrayOfByte;
      }
      int j = 0;
      int k = 0;
      int i = 0;
      byte[] arrayOfByte;
      if ((paramInt1 == 1) && (paramInt2 == 2))
      {
        arrayOfByte = new byte[paramArrayOfByte.length * 2];
        paramInt1 = j;
        if (paramInt3 == 8)
        {
          paramInt1 = i;
          while (paramInt1 < paramArrayOfByte.length)
          {
            paramInt2 = paramInt1 * 2;
            arrayOfByte[paramInt2] = paramArrayOfByte[paramInt1];
            arrayOfByte[(paramInt2 + 1)] = paramArrayOfByte[paramInt1];
            paramInt1 += 1;
          }
        }
        while (paramInt1 < paramArrayOfByte.length / 2)
        {
          paramInt2 = paramInt1 * 4;
          paramInt3 = paramInt1 * 2;
          arrayOfByte[paramInt2] = paramArrayOfByte[paramInt3];
          i = paramInt3 + 1;
          arrayOfByte[(paramInt2 + 1)] = paramArrayOfByte[i];
          arrayOfByte[(paramInt2 + 2)] = paramArrayOfByte[paramInt3];
          arrayOfByte[(paramInt2 + 3)] = paramArrayOfByte[i];
          paramInt1 += 1;
        }
        return arrayOfByte;
      }
      if ((paramInt1 == 2) && (paramInt2 == 1))
      {
        arrayOfByte = new byte[paramArrayOfByte.length / 2];
        if (paramInt3 == 8)
        {
          paramInt1 = k;
          while (paramInt1 < paramArrayOfByte.length / 2)
          {
            paramInt2 = paramInt1 * 2;
            arrayOfByte[paramInt1] = ((byte)((short)(paramArrayOfByte[paramInt2] + paramArrayOfByte[(paramInt2 + 1)]) >> 1));
            paramInt1 += 1;
          }
        }
        if (paramInt3 == 16)
        {
          paramInt1 = 0;
          while (paramInt1 < paramArrayOfByte.length / 4)
          {
            paramInt3 = paramInt1 * 4;
            paramInt2 = (short)((short)((short)((short)paramArrayOfByte[(paramInt3 + 1)] & 0xFF | 0x0) << 8) | (short)paramArrayOfByte[paramInt3] & 0xFF);
            i = (short)((short)((short)paramArrayOfByte[(paramInt3 + 3)] & 0xFF | 0x0) << 8);
            paramInt3 = (short)((short)paramArrayOfByte[(paramInt3 + 2)] & 0xFF | i);
            paramInt2 = (short)(paramInt2 / 2 + paramInt3 / 2);
            paramInt3 = paramInt1 * 2;
            arrayOfByte[paramInt3] = ((byte)(paramInt2 & 0xFF));
            arrayOfByte[(paramInt3 + 1)] = ((byte)((short)(paramInt2 >> 8) & 0xFF));
            paramInt1 += 1;
          }
        }
        return arrayOfByte;
      }
      return paramArrayOfByte;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PCMConverter", 2, "convertChannelCount, srcData == null || srcData.length == 0");
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.PCMConverter
 * JD-Core Version:    0.7.0.1
 */