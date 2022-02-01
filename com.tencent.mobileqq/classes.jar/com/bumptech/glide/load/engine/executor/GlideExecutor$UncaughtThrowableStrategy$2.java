package com.bumptech.glide.load.engine.executor;

import android.util.Log;

class GlideExecutor$UncaughtThrowableStrategy$2
  implements GlideExecutor.UncaughtThrowableStrategy
{
  public void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (Log.isLoggable("GlideExecutor", 6))) {
      Log.e("GlideExecutor", "Request threw uncaught throwable", paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
 * JD-Core Version:    0.7.0.1
 */