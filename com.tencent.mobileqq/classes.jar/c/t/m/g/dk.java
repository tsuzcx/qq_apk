package c.t.m.g;

import android.os.Looper;

public abstract class dk
  extends dl
{
  public abstract int a(Looper paramLooper);
  
  public final int b(Looper paramLooper)
  {
    synchronized (this.n)
    {
      if (this.m) {
        return -1;
      }
      this.m = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dk
 * JD-Core Version:    0.7.0.1
 */