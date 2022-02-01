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
      ol.b.a locala = this.a;
      locala.f = paramT;
      locala.a(locala.i, this.a.g, this.a.k);
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
        os.a locala = os.a("DispatchUtil");
        localStringBuilder = new StringBuilder("future:");
        localStringBuilder.append(this.a.e);
        localStringBuilder.toString();
        locala.a();
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
        catch (InterruptedException localInterruptedException)
        {
          this.a.g.removeCallbacks(this);
          Log.wtf("DispatchUtil", localInterruptedException);
          Thread.currentThread().interrupt();
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          this.a.g.removeCallbacks(this);
          Log.wtf("DispatchUtil", localExecutionException);
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
      localObject = this.a;
      ((ol.b.a)localObject).a(((ol.b.a)localObject).i, this.a.g, this.a.k);
      return;
    }
    Object localObject = os.a("DispatchUtil");
    StringBuilder localStringBuilder = new StringBuilder("future:");
    localStringBuilder.append(this.a.e);
    localStringBuilder.toString();
    ((os.a)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.b
 * JD-Core Version:    0.7.0.1
 */