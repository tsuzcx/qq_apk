package com.tencent.luggage.wxa.ad;

import com.tencent.luggage.wxa.j.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private d c;
  private long d;
  
  public int a(long paramLong)
  {
    return this.c.a(paramLong - this.d);
  }
  
  public long a(int paramInt)
  {
    return this.c.a(paramInt) + this.d;
  }
  
  public void a()
  {
    super.a();
    this.c = null;
  }
  
  public void a(long paramLong1, d paramd, long paramLong2)
  {
    this.a = paramLong1;
    this.c = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.a;
    }
    this.d = paramLong1;
  }
  
  public int b()
  {
    return this.c.b();
  }
  
  public List<a> b(long paramLong)
  {
    return this.c.b(paramLong - this.d);
  }
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ad.i
 * JD-Core Version:    0.7.0.1
 */