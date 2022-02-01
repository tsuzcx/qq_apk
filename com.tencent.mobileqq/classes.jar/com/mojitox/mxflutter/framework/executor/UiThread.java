package com.mojitox.mxflutter.framework.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

public class UiThread
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(@NonNull Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
  
  public static boolean a()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static void b(@NonNull Runnable paramRunnable)
  {
    a.postAtFrontOfQueue(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.UiThread
 * JD-Core Version:    0.7.0.1
 */