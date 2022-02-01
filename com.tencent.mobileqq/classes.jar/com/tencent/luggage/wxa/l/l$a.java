package com.tencent.luggage.wxa.l;

import java.util.Arrays;

public final class l$a
{
  public final int a;
  public final byte[] b;
  public final int c;
  public final int d;
  
  public l$a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramArrayOfByte;
    this.c = paramInt2;
    this.d = paramInt3;
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
      paramObject = (a)paramObject;
      return (this.a == paramObject.a) && (this.c == paramObject.c) && (this.d == paramObject.d) && (Arrays.equals(this.b, paramObject.b));
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a * 31 + Arrays.hashCode(this.b)) * 31 + this.c) * 31 + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.l.a
 * JD-Core Version:    0.7.0.1
 */