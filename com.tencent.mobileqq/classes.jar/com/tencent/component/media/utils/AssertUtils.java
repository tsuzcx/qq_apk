package com.tencent.component.media.utils;

import com.tencent.component.media.annotation.Public;

@Public
public class AssertUtils
{
  @Public
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  @Public
  public static void assertTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */