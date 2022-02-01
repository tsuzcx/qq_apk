package com.tencent.biz.pubaccount.util;

import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;

public class GifHelper
{
  private static int a;
  
  public static void a()
  {
    a = AbstractGifImage.DoAccumulativeRunnable.DELAY;
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
  }
  
  public static void b()
  {
    AbstractGifImage.DoAccumulativeRunnable.DELAY = a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GifHelper
 * JD-Core Version:    0.7.0.1
 */