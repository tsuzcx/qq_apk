package c.t.m.g;

import android.os.Looper;

public abstract class dj
  extends dk
{
  public abstract int a(Looper paramLooper);
  
  public final int b(Looper paramLooper)
  {
    synchronized (this.p)
    {
      if (this.o) {
        return -1;
      }
      this.o = true;
      if (co.e())
      {
        b();
        co.a("startup()");
      }
      int i = a(paramLooper);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dj
 * JD-Core Version:    0.7.0.1
 */