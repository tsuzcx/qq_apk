package com.tencent.beacon.core.a;

class c
  implements Runnable
{
  c(d.a parama, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.d.i.a().a("599", "[task] run occur error!", localThrowable);
      com.tencent.beacon.core.e.i.a(localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.c
 * JD-Core Version:    0.7.0.1
 */