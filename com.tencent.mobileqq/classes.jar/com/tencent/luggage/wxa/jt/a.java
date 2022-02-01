package com.tencent.luggage.wxa.jt;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class a
  implements Executor
{
  private static a a;
  private final Scheduler b = Schedulers.from(this);
  private final Handler c = new Handler(Looper.getMainLooper());
  
  public static Scheduler a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a.b;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jt.a
 * JD-Core Version:    0.7.0.1
 */