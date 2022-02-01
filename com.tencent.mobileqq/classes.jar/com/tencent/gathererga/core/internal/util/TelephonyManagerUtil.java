package com.tencent.gathererga.core.internal.util;

public final class TelephonyManagerUtil
{
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    case 18: 
    default: 
      return 0L;
    case 20: 
      return 524288L;
    case 19: 
      return 262144L;
    case 17: 
      return 65536L;
    case 16: 
      return 32768L;
    case 15: 
      return 16384L;
    case 14: 
      return 8192L;
    case 13: 
      return 4096L;
    case 12: 
      return 2048L;
    case 10: 
      return 512L;
    case 9: 
      return 256L;
    case 8: 
      return 128L;
    case 7: 
      return 64L;
    case 6: 
      return 32L;
    case 5: 
      return 16L;
    case 4: 
      return 8L;
    case 3: 
      return 4L;
    case 2: 
      return 2L;
    }
    return 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.TelephonyManagerUtil
 * JD-Core Version:    0.7.0.1
 */