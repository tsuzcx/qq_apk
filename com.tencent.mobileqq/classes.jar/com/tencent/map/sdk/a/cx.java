package com.tencent.map.sdk.a;

public final class cx
  implements cb, cv
{
  private static cx a = new cx();
  private cv b;
  private cb c;
  private boolean d = false;
  
  public static cx e()
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
  
  public final void a(cb paramcb)
  {
    this.c = paramcb;
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
      this.b = cn.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.cx
 * JD-Core Version:    0.7.0.1
 */