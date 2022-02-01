package com.tencent.featuretoggle.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil
{
  private static final ExecutorService a = ;
  
  public static void a(Runnable paramRunnable)
  {
    try
    {
      if ((a != null) && (!a.isShutdown()))
      {
        if (paramRunnable == null)
        {
          LogUtils.c("execute task is null", new Object[0]);
          return;
        }
        try
        {
          a.execute(paramRunnable);
        }
        catch (Throwable paramRunnable)
        {
          if (!LogUtils.a(paramRunnable)) {
            paramRunnable.printStackTrace();
          }
        }
        return;
      }
      LogUtils.c("async handler was closed , should not execute task!", new Object[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */