package com.tencent.biz.qqstory.album.strategy;

public class SplitConfig
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 5: 
    case 6: 
    default: 
      return 6;
    case 4: 
      return 10;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.SplitConfig
 * JD-Core Version:    0.7.0.1
 */