package com.tencent.ilivesdk.pluginloaderservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManagerExecutor
{
  private static ExecutorService a = null;
  
  public static ExecutorService a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = Executors.newScheduledThreadPool(4);
      }
      return a;
    }
    finally {}
  }
  
  public static void a(ExecutorService paramExecutorService)
  {
    a = paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.ThreadManagerExecutor
 * JD-Core Version:    0.7.0.1
 */