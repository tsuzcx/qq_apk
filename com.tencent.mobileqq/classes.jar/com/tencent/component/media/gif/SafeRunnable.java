package com.tencent.component.media.gif;

abstract class SafeRunnable
  implements Runnable
{
  final NewGifDrawable mGifDrawable;
  
  SafeRunnable(NewGifDrawable paramNewGifDrawable)
  {
    this.mGifDrawable = paramNewGifDrawable;
  }
  
  abstract void doWork();
  
  public final void run()
  {
    try
    {
      if (!this.mGifDrawable.isRecycled())
      {
        doWork();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null) {
        localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.gif.SafeRunnable
 * JD-Core Version:    0.7.0.1
 */