package com.b.a;

import java.util.concurrent.BlockingQueue;

final class c$1
  implements Runnable
{
  c$1(c paramc, m paramm) {}
  
  public final void run()
  {
    try
    {
      c.a(this.b).put(this.a);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.b.a.c.1
 * JD-Core Version:    0.7.0.1
 */