package com.tencent.luggage.wxa.pk;

public class b
  extends Exception
{
  private int a;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public b(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pk.b
 * JD-Core Version:    0.7.0.1
 */