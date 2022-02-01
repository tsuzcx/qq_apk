package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

class GlideExecutor$DefaultThreadFactory$1
  extends Thread
{
  GlideExecutor$DefaultThreadFactory$1(GlideExecutor.DefaultThreadFactory paramDefaultThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(9);
    if (this.this$0.b) {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
    }
    try
    {
      super.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$0.a.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */