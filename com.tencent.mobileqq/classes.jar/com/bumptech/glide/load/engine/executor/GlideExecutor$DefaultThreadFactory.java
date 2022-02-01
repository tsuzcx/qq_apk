package com.bumptech.glide.load.engine.executor;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class GlideExecutor$DefaultThreadFactory
  implements ThreadFactory
{
  final GlideExecutor.UncaughtThrowableStrategy a;
  final boolean b;
  private final String c;
  private int d;
  
  GlideExecutor$DefaultThreadFactory(String paramString, GlideExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy, boolean paramBoolean)
  {
    this.c = paramString;
    this.a = paramUncaughtThrowableStrategy;
    this.b = paramBoolean;
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("glide-");
      localStringBuilder.append(this.c);
      localStringBuilder.append("-thread-");
      localStringBuilder.append(this.d);
      paramRunnable = new GlideExecutor.DefaultThreadFactory.1(this, paramRunnable, localStringBuilder.toString());
      this.d += 1;
      return paramRunnable;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory
 * JD-Core Version:    0.7.0.1
 */