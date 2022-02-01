package com.tencent.map.sdk.a;

public final class pa
{
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return paramArrayOfByte[3] << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString).trim();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >> 8), (byte)(paramInt >> 16), (byte)(paramInt >> 24) };
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = paramString.getBytes("UTF-16LE");
      return paramString;
    }
    catch (Exception paramString)
    {
      label13:
      break label13;
    }
    return new byte[0];
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-16LE").trim();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label16:
      break label16;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pa
 * JD-Core Version:    0.7.0.1
 */