package com.tencent.ilive.uicomponent.luxurygiftcomponent.utils;

import java.util.Random;

public class RandomUtils
{
  private static Random _random;
  
  private static Random getRandom()
  {
    if (_random == null) {
      _random = new Random(System.currentTimeMillis());
    }
    return _random;
  }
  
  public static float nextFloat()
  {
    return getRandom().nextFloat();
  }
  
  public static int nextInt()
  {
    return getRandom().nextInt();
  }
  
  public static int nextInt(int paramInt)
  {
    return getRandom().nextInt(paramInt);
  }
  
  public static long nextLong()
  {
    return getRandom().nextLong();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.utils.RandomUtils
 * JD-Core Version:    0.7.0.1
 */