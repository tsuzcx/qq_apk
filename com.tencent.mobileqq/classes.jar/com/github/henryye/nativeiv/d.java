package com.github.henryye.nativeiv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 enum d
{
  private static int b = Runtime.getRuntime().availableProcessors() + 1;
  private ExecutorService c = null;
  private ExecutorService d = null;
  
  private d()
  {
    a();
  }
  
  private void a()
  {
    int i = Math.max(b, 5);
    this.c = new ThreadPoolExecutor(1, Math.max(i / 2, 4), 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d.1(this));
    this.d = new ThreadPoolExecutor(i - 1, i, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d.2(this));
  }
  
  void a(Runnable paramRunnable)
  {
    this.c.execute(paramRunnable);
  }
  
  void b(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.d
 * JD-Core Version:    0.7.0.1
 */