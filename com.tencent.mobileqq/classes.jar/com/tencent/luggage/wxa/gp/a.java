package com.tencent.luggage.wxa.gp;

public class a
{
  public static short a(byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramByte1 = (short)((short)(paramByte1 & 0xFF | 0x0) << 8) | paramByte2 & 0xFF;
    } else {
      paramByte1 = paramByte1 & 0xFF | (short)((short)(paramByte2 & 0xFF | 0x0) << 8);
    }
    return (short)paramByte1;
  }
  
  public static byte[] a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, boolean paramBoolean)
  {
    int i = a(paramByte1, paramByte2, paramBoolean);
    int j = a(paramByte3, paramByte4, paramBoolean);
    return a((short)(i / 2 + j / 2), paramBoolean);
  }
  
  public static byte[] a(short paramShort, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean)
    {
      arrayOfByte[1] = ((byte)(paramShort & 0xFF));
      arrayOfByte[0] = ((byte)((short)(paramShort >> 8) & 0xFF));
      return arrayOfByte;
    }
    arrayOfByte[0] = ((byte)(paramShort & 0xFF));
    arrayOfByte[1] = ((byte)((short)(paramShort >> 8) & 0xFF));
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, double paramDouble)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      double d = paramArrayOfByte[i];
      Double.isNaN(d);
      paramArrayOfByte[i] = ((byte)(int)(d * paramDouble));
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  public static byte[] a(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length << 1];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      int j = i * 2;
      arrayOfByte[j] = ((byte)(paramArrayOfShort[i] & 0xFF));
      arrayOfByte[(j + 1)] = ((byte)((paramArrayOfShort[i] & 0xFF00) >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static short[] a(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    paramInt = 0;
    while (paramInt < arrayOfShort.length)
    {
      int i = paramInt * 2;
      int j = paramArrayOfByte[i];
      arrayOfShort[paramInt] = ((short)((paramArrayOfByte[(i + 1)] & 0xFF) << 8 | j & 0xFF));
      paramInt += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.a
 * JD-Core Version:    0.7.0.1
 */