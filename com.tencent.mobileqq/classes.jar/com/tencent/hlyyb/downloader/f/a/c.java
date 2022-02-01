package com.tencent.hlyyb.downloader.f.a;

import java.util.concurrent.FutureTask;

public final class c<T>
  extends FutureTask<T>
  implements Comparable<c<T>>
{
  private Object a;
  
  public c(Runnable paramRunnable, T paramT)
  {
    super(paramT, null);
    this.a = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.f.a.c
 * JD-Core Version:    0.7.0.1
 */