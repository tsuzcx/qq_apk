package c.t.m.g;

public final class cf
  implements bj, cd
{
  private static cf a = new cf();
  private cd b;
  private bj c;
  private boolean d = false;
  
  public static cf e()
  {
    return a;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void a(bj parambj)
  {
    this.c = parambj;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.c.a(paramString1, paramArrayOfByte, paramString2);
  }
  
  public final void b()
  {
    this.b.b();
  }
  
  public final void c()
  {
    this.c.c();
  }
  
  public final void d()
  {
    try
    {
      boolean bool = this.d;
      if (bool) {
        return;
      }
      this.b = bv.c();
      if (this.b != null)
      {
        this.b.a(this);
        this.b.d();
      }
      this.d = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cf
 * JD-Core Version:    0.7.0.1
 */