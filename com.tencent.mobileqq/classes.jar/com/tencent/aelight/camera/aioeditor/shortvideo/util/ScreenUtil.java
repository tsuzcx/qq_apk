package com.tencent.aelight.camera.aioeditor.shortvideo.util;

public class ScreenUtil
{
  private static float a = 1.1F;
  private static float b = 1.34F;
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    float f = paramInt2 * 1.0F / paramInt1;
    return (f > a) && (f < b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */