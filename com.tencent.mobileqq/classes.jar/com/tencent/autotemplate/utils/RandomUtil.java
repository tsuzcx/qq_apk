package com.tencent.autotemplate.utils;

import java.util.Random;

public class RandomUtil
{
  public static int RandomInt(int paramInt1, int paramInt2)
  {
    return new Random().nextInt(paramInt2 - paramInt1) + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.RandomUtil
 * JD-Core Version:    0.7.0.1
 */