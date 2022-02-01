package com.tencent.falco.utils;

import android.os.Handler;
import android.text.TextUtils;

public class ThreadCenter
{
  public static boolean debugEnv = false;
  public static ThreadCenter.HandlerKeyable sDefaultHandlerKey = new ThreadCenter.1();
  static ThreadCenter.ThreadImpl threadImpl = new ThreadCenter.ThreadImpl();
  
  public static void clear(ThreadCenter.HandlerKeyable paramHandlerKeyable)
  {
    threadImpl.clear(paramHandlerKeyable);
  }
  
  public static Handler getHandler(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return threadImpl.getHandler(paramString);
    }
    throw new RuntimeException("Thread name null!");
  }
  
  public static void init() {}
  
  public static void postDefaultUITask(Runnable paramRunnable)
  {
    threadImpl.postMainTask(sDefaultHandlerKey, paramRunnable, 0L, false);
  }
  
  public static void postDefaultUITask(Runnable paramRunnable, long paramLong)
  {
    threadImpl.postMainTask(sDefaultHandlerKey, paramRunnable, paramLong, false);
  }
  
  public static void postDefaultUITask(Runnable paramRunnable, boolean paramBoolean)
  {
    threadImpl.postMainTask(sDefaultHandlerKey, paramRunnable, 0L, paramBoolean);
  }
  
  public static void postDelayedLogicTask(Runnable paramRunnable, int paramInt)
  {
    threadImpl.postLogicTask(paramRunnable, paramInt, false, null);
  }
  
  public static void postDelayedLogicTask(Runnable paramRunnable, long paramLong, String paramString)
  {
    threadImpl.postLogicTask(paramRunnable, paramLong, false, paramString);
  }
  
  public static void postDelayedUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable, long paramLong)
  {
    threadImpl.postMainTask(paramHandlerKeyable, paramRunnable, paramLong, false);
  }
  
  public static void postLogicTask(Runnable paramRunnable)
  {
    threadImpl.postLogicTask(paramRunnable, 0L, false, null);
  }
  
  public static void postLogicTask(Runnable paramRunnable, String paramString)
  {
    threadImpl.postLogicTask(paramRunnable, 0L, false, paramString);
  }
  
  public static void postLogicTask(Runnable paramRunnable, boolean paramBoolean)
  {
    threadImpl.postLogicTask(paramRunnable, 0L, paramBoolean, null);
  }
  
  public static void postLogicTask(Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    threadImpl.postLogicTask(paramRunnable, 0L, paramBoolean, paramString);
  }
  
  public static void postUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    threadImpl.postMainTask(paramHandlerKeyable, paramRunnable, 0L, false);
  }
  
  public static void postUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable, boolean paramBoolean)
  {
    threadImpl.postMainTask(paramHandlerKeyable, paramRunnable, 0L, paramBoolean);
  }
  
  public static void removeDefaultUITask(Runnable paramRunnable)
  {
    threadImpl.removeUITask(sDefaultHandlerKey, paramRunnable);
  }
  
  public static void removeLogicTask(Runnable paramRunnable)
  {
    threadImpl.removeLogicTask(paramRunnable, null);
  }
  
  public static void removeLogicTask(Runnable paramRunnable, String paramString)
  {
    threadImpl.removeLogicTask(paramRunnable, paramString);
  }
  
  public static void removeUITask(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    threadImpl.removeUITask(paramHandlerKeyable, paramRunnable);
  }
  
  public static void setDebugMode()
  {
    debugEnv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter
 * JD-Core Version:    0.7.0.1
 */