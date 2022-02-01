package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.h.k;
import java.util.Arrays;

public final class n
{
  public final int a;
  private final k[] b;
  private int c;
  
  public n(k... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    this.b = paramVarArgs;
    this.a = paramVarArgs.length;
  }
  
  public int a(k paramk)
  {
    int i = 0;
    for (;;)
    {
      k[] arrayOfk = this.b;
      if (i >= arrayOfk.length) {
        break;
      }
      if (paramk == arrayOfk[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public k a(int paramInt)
  {
    return this.b[paramInt];
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
      paramObject = (n)paramObject;
      return (this.a == paramObject.a) && (Arrays.equals(this.b, paramObject.b));
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
 * Qualified Name:     com.tencent.luggage.wxa.z.n
 * JD-Core Version:    0.7.0.1
 */