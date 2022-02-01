package com.tencent.luggage.wxa.hj;

class l$a$2$1
  implements Runnable
{
  l$a$2$1(l.a.2 param2, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler2 = Thread.currentThread().getUncaughtExceptionHandler();
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler1 = localUncaughtExceptionHandler2;
      if (localUncaughtExceptionHandler2 == null) {
        localUncaughtExceptionHandler1 = Thread.getDefaultUncaughtExceptionHandler();
      }
      if (localUncaughtExceptionHandler1 != null) {
        localUncaughtExceptionHandler1.uncaughtException(Thread.currentThread(), localThrowable);
      }
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.a.2.1
 * JD-Core Version:    0.7.0.1
 */