package com.heytap.mcssdk.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f
{
  private static final ExecutorService a = ;
  private static Handler b = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    a.execute(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable)
  {
    b.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.f
 * JD-Core Version:    0.7.0.1
 */