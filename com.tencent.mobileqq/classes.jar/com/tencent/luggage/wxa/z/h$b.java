package com.tencent.luggage.wxa.z;

public final class h$b
{
  public static final b a = new b(-1, -1, -1);
  public final int b;
  public final int c;
  public final int d;
  
  public h$b(int paramInt)
  {
    this(paramInt, -1, -1);
  }
  
  public h$b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public b a(int paramInt)
  {
    if (this.b == paramInt) {
      return this;
    }
    return new b(paramInt, this.c, this.d);
  }
  
  public boolean a()
  {
    return this.c != -1;
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
      paramObject = (b)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.b) * 31 + this.c) * 31 + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.h.b
 * JD-Core Version:    0.7.0.1
 */