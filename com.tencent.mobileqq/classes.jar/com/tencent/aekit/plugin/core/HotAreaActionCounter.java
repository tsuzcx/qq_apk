package com.tencent.aekit.plugin.core;

public class HotAreaActionCounter
{
  private static int sCount = 0;
  private static boolean sLockUpdate = false;
  
  public static void clear()
  {
    sCount = 0;
  }
  
  public static int getCount()
  {
    return sCount;
  }
  
  public static void lockUpdate()
  {
    sLockUpdate = true;
  }
  
  public static void reset()
  {
    sCount = 0;
    sLockUpdate = false;
  }
  
  public static void updateCount()
  {
    if (sLockUpdate) {
      return;
    }
    sCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.HotAreaActionCounter
 * JD-Core Version:    0.7.0.1
 */