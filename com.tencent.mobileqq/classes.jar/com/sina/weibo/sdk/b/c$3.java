package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

final class c$3
  extends c<Params, Progress, Result>.c
{
  c$3(c paramc, c.d paramd)
  {
    super(paramc, paramd);
  }
  
  public final int compareTo(Object paramObject)
  {
    return 0;
  }
  
  protected final void done()
  {
    try
    {
      Object localObject = get();
      this.W.y.obtainMessage(1, new c.a(this.W, new Object[] { localObject })).sendToTarget();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException("An error occur while execute doInBackground().");
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occur while execute doInBackground().");
    }
    catch (CancellationException localCancellationException)
    {
      this.W.y.obtainMessage(3, new c.a(this.W, null)).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occur while execute doInBackground().");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.c.3
 * JD-Core Version:    0.7.0.1
 */