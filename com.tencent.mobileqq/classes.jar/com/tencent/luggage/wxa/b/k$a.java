package com.tencent.luggage.wxa.b;

import java.io.Writer;

class k$a
  extends i
{
  private final char[] b;
  private int c;
  
  private k$a(Writer paramWriter, char[] paramArrayOfChar)
  {
    super(paramWriter);
    this.b = paramArrayOfChar;
  }
  
  private boolean h()
  {
    char[] arrayOfChar = this.b;
    int i = 0;
    if (arrayOfChar == null) {
      return false;
    }
    this.a.write(10);
    while (i < this.c)
    {
      this.a.write(this.b);
      i += 1;
    }
    return true;
  }
  
  protected void a()
  {
    this.c += 1;
    this.a.write(91);
    h();
  }
  
  protected void b()
  {
    this.c -= 1;
    h();
    this.a.write(93);
  }
  
  protected void c()
  {
    this.a.write(44);
    if (!h()) {
      this.a.write(32);
    }
  }
  
  protected void d()
  {
    this.c += 1;
    this.a.write(123);
    h();
  }
  
  protected void e()
  {
    this.c -= 1;
    h();
    this.a.write(125);
  }
  
  protected void f()
  {
    this.a.write(58);
    this.a.write(32);
  }
  
  protected void g()
  {
    this.a.write(44);
    if (!h()) {
      this.a.write(32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.k.a
 * JD-Core Version:    0.7.0.1
 */