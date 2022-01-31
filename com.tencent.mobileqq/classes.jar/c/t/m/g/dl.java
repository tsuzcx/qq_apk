package c.t.m.g;

import android.os.Looper;
import java.util.Observable;

public abstract class dl
  extends Observable
{
  protected volatile boolean b = false;
  protected byte[] c = new byte[0];
  
  public abstract int a();
  
  public int a(Looper arg1)
  {
    synchronized (this.c)
    {
      if (this.b) {
        return -1;
      }
      this.b = true;
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
  
  public final boolean e()
  {
    synchronized (this.c)
    {
      boolean bool = this.b;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dl
 * JD-Core Version:    0.7.0.1
 */