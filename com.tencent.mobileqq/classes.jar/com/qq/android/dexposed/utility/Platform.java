package com.qq.android.dexposed.utility;

public abstract class Platform
{
  static Platform a = new Platform.Platform32Bit();
  
  static
  {
    if (Runtime.a())
    {
      a = new Platform.Platform64Bit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Platform
 * JD-Core Version:    0.7.0.1
 */