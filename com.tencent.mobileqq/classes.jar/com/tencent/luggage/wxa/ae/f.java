package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.ad.d;
import java.util.Collections;
import java.util.List;

final class f
  implements d
{
  private final List<com.tencent.luggage.wxa.ad.a> a;
  
  public f(List<com.tencent.luggage.wxa.ad.a> paramList)
  {
    this.a = paramList;
  }
  
  public int a(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
  
  public long a(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    return 0L;
  }
  
  public int b()
  {
    return 1;
  }
  
  public List<com.tencent.luggage.wxa.ad.a> b(long paramLong)
  {
    if (paramLong >= 0L) {
      return this.a;
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.f
 * JD-Core Version:    0.7.0.1
 */