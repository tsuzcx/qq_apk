package com.tencent.mobileqq.armap.utils;

import java.io.ByteArrayOutputStream;

public class MySerialize
  implements SerializeConst
{
  private ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public static float a(byte[] paramArrayOfByte)
  {
    return Float.intBitsToFloat(a(paramArrayOfByte));
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | 0xFF00 & paramArrayOfByte[1] << 8 | 0xFF0000 & paramArrayOfByte[2] << 16 | 0xFF000000 & paramArrayOfByte[3] << 24;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.MySerialize
 * JD-Core Version:    0.7.0.1
 */