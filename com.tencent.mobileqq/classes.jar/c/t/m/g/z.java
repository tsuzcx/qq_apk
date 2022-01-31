package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class z
  implements Runnable
{
  z(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      this.a[0] = y.c();
      this.b.countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.a[0] = y.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.z
 * JD-Core Version:    0.7.0.1
 */