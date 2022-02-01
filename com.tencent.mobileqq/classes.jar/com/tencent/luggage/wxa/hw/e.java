package com.tencent.luggage.wxa.hw;

public class e<T extends a>
  implements b, c<T>
{
  private T a;
  
  public e(T paramT)
  {
    this.a = paramT;
  }
  
  public T a()
  {
    return this.a;
  }
  
  public void c()
  {
    a locala = this.a;
    if ((locala instanceof b)) {
      ((b)locala).c();
    }
  }
  
  public void d()
  {
    a locala = this.a;
    if ((locala instanceof b)) {
      ((b)locala).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hw.e
 * JD-Core Version:    0.7.0.1
 */