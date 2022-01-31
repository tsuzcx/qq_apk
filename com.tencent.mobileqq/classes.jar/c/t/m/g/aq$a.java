package c.t.m.g;

import android.os.Handler;

public abstract class aq$a
  implements Runnable
{
  private aq$a(aq paramaq) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!aq.a(this.a).postAtFrontOfQueue(this)) {
        aq.a(this.a).post(this);
      }
      return;
    }
    aq.a(this.a).post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.aq.a
 * JD-Core Version:    0.7.0.1
 */