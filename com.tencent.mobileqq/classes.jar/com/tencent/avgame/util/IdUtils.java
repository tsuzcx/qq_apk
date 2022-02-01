package com.tencent.avgame.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdUtils
{
  private static final AtomicInteger a = new AtomicInteger(1);
  
  public static int a()
  {
    int k;
    int i;
    do
    {
      k = a.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!a.compareAndSet(k, i));
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.IdUtils
 * JD-Core Version:    0.7.0.1
 */