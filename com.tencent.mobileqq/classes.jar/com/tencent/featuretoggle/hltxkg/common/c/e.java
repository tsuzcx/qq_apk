package com.tencent.featuretoggle.hltxkg.common.c;

public final class e
  implements b, c
{
  private static e a = new e();
  private c b;
  private b c;
  private boolean d = false;
  
  public static e e()
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
  
  public final void a(b paramb)
  {
    this.c = paramb;
  }
  
  public final void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.c.a(paramString1, paramArrayOfByte, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
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
      this.b = com.tencent.featuretoggle.hltxkg.common.c.b.b.c.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.e
 * JD-Core Version:    0.7.0.1
 */