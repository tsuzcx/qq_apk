package com.sina.weibo.sdk.b;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final int K;
  private static final int L;
  private static final int M = K * 2 + 1;
  private static final Comparator<Runnable> O = new a.1();
  ThreadPoolExecutor N;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    K = i;
    L = i + 1;
  }
  
  public a()
  {
    if (this.N == null) {
      this.N = new ThreadPoolExecutor(L, M, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, O));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */