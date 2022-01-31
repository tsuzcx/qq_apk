package c.t.m.g;

import android.os.Handler;

final class br
  implements Runnable
{
  br(bo parambo) {}
  
  public final void run()
  {
    try
    {
      o.e();
      bo.a(this.a, o.b());
      bo.b(this.a).removeCallbacks(bo.a(this.a));
      bo.b(this.a).post(bo.a(this.a));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.br
 * JD-Core Version:    0.7.0.1
 */