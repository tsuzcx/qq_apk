package com.tencent.aelight.camera.aioeditor.capture.text;

import java.util.Arrays;

public class SpellUtil
{
  public static String a = "[a-zA-Z0-9\\u4e00-\\u9fa5]";
  private static final int[] b = { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65295, 65306, 65312, 65339, 65344, 65371, 2147483647 };
  
  public static int a(char paramChar)
  {
    if (b(paramChar)) {
      return 3;
    }
    int i = Arrays.binarySearch(b, paramChar);
    if ((i != -16) && (i != -14) && (i != -12) && (i != -10) && (i != -7) && (i != -5) && (i != -3) && (i != 5))
    {
      if (Character.isHighSurrogate(paramChar)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    return Character.codePointCount(paramString, 0, paramString.length());
  }
  
  private static boolean b(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.SpellUtil
 * JD-Core Version:    0.7.0.1
 */