package com.tencent.luggage.wxa.h;

public final class u
{
  public static final u a = new u(0);
  public final int b;
  
  public u(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (u)paramObject;
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.u
 * JD-Core Version:    0.7.0.1
 */