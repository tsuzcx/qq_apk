package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class ol$b$b<T>
  extends ol.a<T>
{
  ol.b.a<T> a;
  
  ol$b$b(ol.b.a<T> parama)
  {
    Object localObject;
    this.a = localObject;
  }
  
  public final void a(T paramT)
  {
    if (Thread.currentThread() != this.a.g.getLooper().getThread())
    {
      os.a("DispatchUtil").a();
      this.a.f = paramT;
      this.a.a(this.a.i, this.a.g, this.a.k);
      return;
    }
    os.a("DispatchUtil").a();
    this.a.a(paramT);
  }
  
  public final void run()
  {
    if ((this.a.e != null) && (!this.a.a))
    {
      if (this.a.e.isDone())
      {
        os.a locala1 = os.a("DispatchUtil");
        new StringBuilder("future:").append(this.a.e).toString();
        locala1.a();
        try
        {
          if (this.a.f != null)
          {
            a(this.a.f);
            return;
          }
          a(this.a.e.get());
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          this.a.g.removeCallbacks(this);
          Log.wtf("DispatchUtil", localExecutionException);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          this.a.g.removeCallbacks(this);
          Log.wtf("DispatchUtil", localInterruptedException);
          Thread.currentThread().interrupt();
          return;
        }
      }
      if (this.a.e.isCancelled())
      {
        os.a("DispatchUtil").a();
        this.a.g.removeCallbacks(this);
        return;
      }
      os.a("DispatchUtil").a();
      this.a.a(this.a.i, this.a.g, this.a.k);
      return;
    }
    os.a locala2 = os.a("DispatchUtil");
    new StringBuilder("future:").append(this.a.e).toString();
    locala2.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.b
 * JD-Core Version:    0.7.0.1
 */