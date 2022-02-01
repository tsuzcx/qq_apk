package com.tencent.luggage.wxa.pd;

public class h
{
  private long a;
  private long b;
  private h.a c;
  
  public h() {}
  
  public h(long paramLong, h.a parama)
  {
    this.a = paramLong;
    this.c = parama;
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.b < this.a;
  }
  
  public boolean a(Object... paramVarArgs)
  {
    if (a()) {
      return false;
    }
    h.a locala = this.c;
    if (locala == null) {
      return false;
    }
    boolean bool = locala.a(paramVarArgs);
    if (bool) {
      b();
    }
    return bool;
  }
  
  public void b()
  {
    this.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.h
 * JD-Core Version:    0.7.0.1
 */