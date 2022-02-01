package c.t.m.g;

public abstract class dl
{
  protected volatile boolean m = false;
  protected byte[] n = new byte[0];
  
  public abstract void a();
  
  public abstract String b();
  
  public final boolean d()
  {
    synchronized (this.n)
    {
      boolean bool = this.m;
      return bool;
    }
  }
  
  public final void e()
  {
    synchronized (this.n)
    {
      if (!this.m) {
        return;
      }
      if (co.e())
      {
        b();
        co.a("shutdown()");
      }
      a();
      this.m = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dl
 * JD-Core Version:    0.7.0.1
 */