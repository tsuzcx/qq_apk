package com.tencent.luggage.wxa.al;

import java.util.Arrays;

public final class f
{
  public final int a;
  private final e[] b;
  private int c;
  
  public f(e... paramVarArgs)
  {
    this.b = paramVarArgs;
    this.a = paramVarArgs.length;
  }
  
  public e a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public e[] a()
  {
    return (e[])this.b.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (f)paramObject;
      return Arrays.equals(this.b, paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.c == 0) {
      this.c = (527 + Arrays.hashCode(this.b));
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.f
 * JD-Core Version:    0.7.0.1
 */