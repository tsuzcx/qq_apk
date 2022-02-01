package com.tencent.beacon.core.network.volley;

import java.util.concurrent.BlockingQueue;

class CacheDispatcher$1
  implements Runnable
{
  CacheDispatcher$1(CacheDispatcher paramCacheDispatcher, Request paramRequest) {}
  
  public void run()
  {
    try
    {
      CacheDispatcher.access$100(this.this$0).put(this.val$request);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.CacheDispatcher.1
 * JD-Core Version:    0.7.0.1
 */