package com.tencent.hippy.qq.update.tool;

public class TypeHelper
{
  public static String byteToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if ((paramArrayOfByte[i] & 0xFF) < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  public static int byteToInt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4)
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      return (paramArrayOfByte[3] & 0xFF) << 0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
    }
    throw new Exception();
  }
  
  public static long byteToLong(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 8)
    {
      long l1 = paramArrayOfByte[0];
      long l2 = paramArrayOfByte[1];
      long l3 = paramArrayOfByte[2];
      long l4 = paramArrayOfByte[3];
      long l5 = paramArrayOfByte[4];
      long l6 = paramArrayOfByte[5];
      long l7 = paramArrayOfByte[6];
      return (0xFF & paramArrayOfByte[7]) << 0 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
    }
    throw new Exception();
  }
  
  public static byte[] hexStringToByte(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")) && (paramString.length() % 2 == 0))
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int j;
      for (int i = 0; i < paramString.length(); i = j)
      {
        int k = i / 2;
        j = i + 2;
        arrayOfByte[k] = ((byte)(Integer.parseInt(paramString.substring(i, j), 16) & 0xFF));
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static byte[] intToByte(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int j = 3;
    int i = paramInt;
    paramInt = j;
    while (paramInt >= 0)
    {
      arrayOfByte[paramInt] = ((byte)(i % 256));
      i >>= 8;
      paramInt -= 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] longToByte(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 7;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong % 256L));
      paramLong >>= 8;
      i -= 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.TypeHelper
 * JD-Core Version:    0.7.0.1
 */