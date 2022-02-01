package com.tencent.luggage.wxa.j;

public abstract class a
{
  private int a;
  
  public void a()
  {
    this.a = 0;
  }
  
  public final void a_(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.a = (paramInt | this.a);
  }
  
  public final void c(int paramInt)
  {
    this.a = ((paramInt ^ 0xFFFFFFFF) & this.a);
  }
  
  public final boolean c()
  {
    return d(4);
  }
  
  public final boolean d()
  {
    return d(1);
  }
  
  protected final boolean d(int paramInt)
  {
    return (this.a & paramInt) == paramInt;
  }
  
  public final boolean e_()
  {
    return d(-2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.j.a
 * JD-Core Version:    0.7.0.1
 */