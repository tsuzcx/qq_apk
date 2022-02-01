package com.tencent.luggage.wxa.z;

import java.util.Arrays;

public final class o
{
  public static final o a = new o(new n[0]);
  public final int b;
  private final n[] c;
  private int d;
  
  public o(n... paramVarArgs)
  {
    this.c = paramVarArgs;
    this.b = paramVarArgs.length;
  }
  
  public int a(n paramn)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.c[i] == paramn) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public n a(int paramInt)
  {
    return this.c[paramInt];
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
      paramObject = (o)paramObject;
      return (this.b == paramObject.b) && (Arrays.equals(this.c, paramObject.c));
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.d == 0) {
      this.d = Arrays.hashCode(this.c);
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.o
 * JD-Core Version:    0.7.0.1
 */