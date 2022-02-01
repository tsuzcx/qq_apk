package c.t.m.g;

import android.os.Looper;

public abstract class dm
  extends dw.a
{
  protected volatile boolean a = false;
  protected byte[] b = new byte[0];
  
  public abstract int a();
  
  public int a(Looper arg1)
  {
    synchronized (this.b)
    {
      if (this.a) {
        return -1;
      }
      this.a = true;
      if (co.e())
      {
        c();
        co.a("startup()");
      }
      int i = a();
      return i;
    }
  }
  
  public abstract void b();
  
  public abstract String c();
  
  public final boolean f()
  {
    synchronized (this.b)
    {
      boolean bool = this.a;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.dm
 * JD-Core Version:    0.7.0.1
 */