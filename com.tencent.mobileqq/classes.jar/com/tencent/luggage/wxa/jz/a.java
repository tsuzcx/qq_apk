package com.tencent.luggage.wxa.jz;

public abstract class a
  implements d, Runnable
{
  private long a = 0L;
  private long b = 0L;
  
  public void a()
  {
    this.a = System.currentTimeMillis();
    b.a(this);
  }
  
  public void b()
  {
    this.a = System.currentTimeMillis();
    d();
  }
  
  public void c()
  {
    String str = getClass().getName();
    if (str.contains("$"))
    {
      str.substring(str.lastIndexOf("$") + 1);
      System.currentTimeMillis();
      long l = this.a;
      System.currentTimeMillis();
      l = this.b;
      this.b = 0L;
      this.a = 0L;
    }
  }
  
  public void run()
  {
    this.b = System.currentTimeMillis();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.a
 * JD-Core Version:    0.7.0.1
 */