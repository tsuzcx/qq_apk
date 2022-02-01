package com.tencent.luggage.wxa.qy;

public abstract class b
{
  private int a = 0;
  public Runnable c = null;
  protected boolean d;
  
  int c()
  {
    if (this.a == 0) {
      this.a = getClass().getName().hashCode();
    }
    return this.a;
  }
  
  public boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qy.b
 * JD-Core Version:    0.7.0.1
 */