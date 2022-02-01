package com.bumptech.glide.load.engine.executor;

class GlideExecutor$UncaughtThrowableStrategy$3
  implements GlideExecutor.UncaughtThrowableStrategy
{
  public void a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    throw new RuntimeException("Request threw uncaught throwable", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
 * JD-Core Version:    0.7.0.1
 */