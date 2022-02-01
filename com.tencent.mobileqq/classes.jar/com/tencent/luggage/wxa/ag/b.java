package com.tencent.luggage.wxa.ag;

import com.tencent.luggage.wxa.ad.d;
import com.tencent.luggage.wxa.ao.x;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.tencent.luggage.wxa.ad.a[] a;
  private final long[] b;
  
  public b(com.tencent.luggage.wxa.ad.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.a = paramArrayOfa;
    this.b = paramArrayOfLong;
  }
  
  public int a(long paramLong)
  {
    int i = x.b(this.b, paramLong, false, false);
    if (i < this.b.length) {
      return i;
    }
    return -1;
  }
  
  public long a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1);
    if (paramInt < this.b.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1);
    return this.b[paramInt];
  }
  
  public int b()
  {
    return this.b.length;
  }
  
  public List<com.tencent.luggage.wxa.ad.a> b(long paramLong)
  {
    int i = x.a(this.b, paramLong, true, false);
    if (i != -1)
    {
      com.tencent.luggage.wxa.ad.a[] arrayOfa = this.a;
      if (arrayOfa[i] != null) {
        return Collections.singletonList(arrayOfa[i]);
      }
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ag.b
 * JD-Core Version:    0.7.0.1
 */