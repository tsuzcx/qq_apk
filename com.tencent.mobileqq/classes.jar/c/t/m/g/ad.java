package c.t.m.g;

import java.util.concurrent.CountDownLatch;

final class ad
  implements Runnable
{
  ad(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      this.a[0] = ac.b();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ad
 * JD-Core Version:    0.7.0.1
 */