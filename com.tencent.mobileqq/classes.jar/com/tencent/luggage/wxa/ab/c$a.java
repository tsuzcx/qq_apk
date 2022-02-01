package com.tencent.luggage.wxa.ab;

import com.tencent.luggage.wxa.aa.c;
import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.h.k;
import java.util.Arrays;

final class c$a
  extends c
{
  public final String i;
  private byte[] j;
  
  public c$a(g paramg, j paramj, k paramk, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
  {
    super(paramg, paramj, 3, paramk, paramInt, paramObject, paramArrayOfByte);
    this.i = paramString;
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.j = Arrays.copyOf(paramArrayOfByte, paramInt);
  }
  
  public byte[] f()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.c.a
 * JD-Core Version:    0.7.0.1
 */