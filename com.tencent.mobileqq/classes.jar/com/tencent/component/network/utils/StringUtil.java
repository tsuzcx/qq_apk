package com.tencent.component.network.utils;

public class StringUtil
{
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */