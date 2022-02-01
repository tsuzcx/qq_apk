package com.qq.android.dexposed.utility;

public abstract class Platform
{
  static Platform PLATFORM_INTERNAL = new Platform.Platform32Bit();
  
  static
  {
    if (Runtime.is64Bit())
    {
      PLATFORM_INTERNAL = new Platform.Platform64Bit();
      return;
    }
  }
  
  public static Platform getPlatform()
  {
    return PLATFORM_INTERNAL;
  }
  
  public abstract int getIntSize();
  
  public abstract int orderByteToInt(byte[] paramArrayOfByte);
  
  public abstract long orderByteToLong(byte[] paramArrayOfByte);
  
  public abstract byte[] orderIntToByte(int paramInt);
  
  public abstract byte[] orderLongToByte(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Platform
 * JD-Core Version:    0.7.0.1
 */