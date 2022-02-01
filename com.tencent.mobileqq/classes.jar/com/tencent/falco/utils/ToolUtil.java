package com.tencent.falco.utils;

public class ToolUtil
{
  private static long lastClickTime;
  
  public static boolean isDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - lastClickTime;
    if ((0L < l2) && (l2 < 1000L)) {
      return true;
    }
    lastClickTime = l1;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.ToolUtil
 * JD-Core Version:    0.7.0.1
 */