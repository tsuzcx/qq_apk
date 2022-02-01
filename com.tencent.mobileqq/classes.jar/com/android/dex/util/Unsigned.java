package com.android.dex.util;

public final class Unsigned
{
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return 0;
    }
    if ((paramInt1 & 0xFFFFFFFF) < (paramInt2 & 0xFFFFFFFF)) {
      return -1;
    }
    return 1;
  }
  
  public static int compare(short paramShort1, short paramShort2)
  {
    if (paramShort1 == paramShort2) {
      return 0;
    }
    if ((paramShort1 & 0xFFFF) < (0xFFFF & paramShort2)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.util.Unsigned
 * JD-Core Version:    0.7.0.1
 */