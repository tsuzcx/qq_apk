package com.b.a;

import android.os.Handler;
import java.util.concurrent.Executor;

final class e
  implements Executor
{
  e(p paramp, Handler paramHandler) {}
  
  public final void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.b.a.e
 * JD-Core Version:    0.7.0.1
 */