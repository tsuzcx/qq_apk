package com.tencent.biz.qrcode.logindev;

public class LoginDevicesUtils
{
  public static int a(int paramInt)
  {
    if (paramInt == 65793) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    if (paramInt == 3) {
      return 3;
    }
    if (b(paramInt)) {
      return 5;
    }
    if (paramInt == 77313) {
      return 6;
    }
    return 0;
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 65793L) || (paramLong == 77313L) || (paramLong == 66831L) || (paramLong == 66818L) || (paramLong == 81154L);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 14) || (paramInt == 16) || ((paramInt >= 100) && (paramInt < 200));
  }
  
  public static boolean b(long paramLong)
  {
    return (paramLong == 72194L) || (paramLong == 68361L) || (paramLong == 65805L) || (paramLong == 68104L);
  }
  
  public static boolean c(long paramLong)
  {
    return (paramLong == 78082L) || (paramLong == 78096L) || (paramLong == 75023L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevicesUtils
 * JD-Core Version:    0.7.0.1
 */