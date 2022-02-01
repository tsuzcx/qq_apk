package com.tencent.gamecenter.http.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpConnectionManager
{
  private static AsyncHttpConnectionManager a;
  private ExecutorService b = Executors.newFixedThreadPool(5);
  
  public static AsyncHttpConnectionManager a()
  {
    if (a == null) {
      a = new AsyncHttpConnectionManager();
    }
    return a;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.b.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.http.utils.AsyncHttpConnectionManager
 * JD-Core Version:    0.7.0.1
 */