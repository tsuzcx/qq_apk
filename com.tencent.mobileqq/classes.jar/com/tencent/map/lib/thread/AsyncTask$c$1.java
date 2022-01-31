package com.tencent.map.lib.thread;

final class AsyncTask$c$1
  implements Runnable
{
  AsyncTask$c$1(AsyncTask.c paramc, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.c.1
 * JD-Core Version:    0.7.0.1
 */