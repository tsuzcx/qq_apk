package com.qq.android.dexposed.utility;

public final class Debug
{
  public static String a(byte paramByte)
  {
    return String.format("%02X", new Object[] { Byte.valueOf(paramByte) });
  }
  
  public static String a(int paramInt)
  {
    return String.format("0x%08X", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String a(long paramLong)
  {
    return "none in release mode.";
  }
  
  public static String a(byte[] paramArrayOfByte, long paramLong)
  {
    return "none in release mode.";
  }
  
  public static String b(long paramLong)
  {
    return String.format("0x%016X", new Object[] { Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Debug
 * JD-Core Version:    0.7.0.1
 */