package c.t.m.g;

import android.os.Looper;

public abstract class cn
{
  public volatile boolean a = false;
  public byte[] b = new byte[0];
  
  public abstract void a(Looper paramLooper);
  
  public final boolean a()
  {
    synchronized (this.b)
    {
      boolean bool = this.a;
      return bool;
    }
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cn
 * JD-Core Version:    0.7.0.1
 */