package com.tencent.luggage.wxa.ai;

import com.tencent.luggage.wxa.ad.a;
import com.tencent.luggage.wxa.ad.d;
import com.tencent.luggage.wxa.ao.x;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class f
  implements d
{
  private final b a;
  private final long[] b;
  private final Map<String, e> c;
  private final Map<String, c> d;
  
  public f(b paramb, Map<String, e> paramMap, Map<String, c> paramMap1)
  {
    this.a = paramb;
    this.d = paramMap1;
    if (paramMap != null) {
      paramMap = Collections.unmodifiableMap(paramMap);
    } else {
      paramMap = Collections.emptyMap();
    }
    this.c = paramMap;
    this.b = paramb.b();
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
    return this.b[paramInt];
  }
  
  public int b()
  {
    return this.b.length;
  }
  
  public List<a> b(long paramLong)
  {
    return this.a.a(paramLong, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ai.f
 * JD-Core Version:    0.7.0.1
 */