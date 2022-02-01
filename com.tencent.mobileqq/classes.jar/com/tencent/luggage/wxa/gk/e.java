package com.tencent.luggage.wxa.gk;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.gi.c.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e
  implements Runnable
{
  private final FutureTask<?> a;
  
  public e(@NonNull Runnable paramRunnable)
  {
    this.a = new FutureTask(paramRunnable, Integer.valueOf(0));
  }
  
  public <T> e(@NonNull Callable<T> paramCallable)
  {
    this.a = new FutureTask(paramCallable);
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      this.a.get(paramLong, TimeUnit.MILLISECONDS);
      return true;
    }
    catch (TimeoutException localTimeoutException)
    {
      c.c.a("MagicBrush.SyncTask", localTimeoutException, "execute timeout", new Object[0]);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      c.c.a("MagicBrush.SyncTask", localExecutionException, "execute failed", new Object[0]);
      return false;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.a("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
    }
    return false;
  }
  
  public boolean b()
  {
    return this.a.isDone();
  }
  
  public <T> T c()
  {
    try
    {
      Object localObject = this.a.get();
      return localObject;
    }
    catch (ExecutionException localExecutionException)
    {
      c.c.a("MagicBrush.SyncTask", localExecutionException, "execute failed", new Object[0]);
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.a("MagicBrush.SyncTask", localInterruptedException, "await failed", new Object[0]);
    }
    return null;
  }
  
  public void run()
  {
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.e
 * JD-Core Version:    0.7.0.1
 */