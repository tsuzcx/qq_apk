package com.tencent.luggage.wxa.km;

public final class i$a
{
  private int a = 0;
  private final int b = 1;
  private long c = 0L;
  
  public a a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.a = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid scan mode ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public i a()
  {
    return new i(this.a, 1, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.i.a
 * JD-Core Version:    0.7.0.1
 */