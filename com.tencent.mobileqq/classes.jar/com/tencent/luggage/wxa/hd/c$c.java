package com.tencent.luggage.wxa.hd;

class c$c
  extends c.a
{
  private final a a = a.a();
  private final int b;
  
  c$c(int paramInt)
  {
    super(null);
    this.b = paramInt;
  }
  
  protected boolean b()
  {
    return this.a.b();
  }
  
  protected String c()
  {
    String str = (String)this.a.a(this.b);
    if ((str == null) && (!this.a.b()))
    {
      int i = this.b;
      if ((i == 256) || (i == 258)) {}
    }
    return str;
  }
  
  protected void c(String paramString)
  {
    this.a.a(this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.c
 * JD-Core Version:    0.7.0.1
 */