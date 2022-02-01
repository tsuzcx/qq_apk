package com.google.android.exoplayer2.util;

public final class RepeatModeUtil
{
  public static final int REPEAT_TOGGLE_MODE_ALL = 2;
  public static final int REPEAT_TOGGLE_MODE_NONE = 0;
  public static final int REPEAT_TOGGLE_MODE_ONE = 1;
  
  public static int getNextRepeatMode(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (i <= 2)
    {
      int j = (paramInt1 + i) % 3;
      if (isRepeatModeEnabled(j, paramInt2)) {
        return j;
      }
      i += 1;
    }
    return paramInt1;
  }
  
  public static boolean isRepeatModeEnabled(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return false;
        }
        return (paramInt2 & 0x2) != 0;
      }
      if ((paramInt2 & 0x1) != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.RepeatModeUtil
 * JD-Core Version:    0.7.0.1
 */