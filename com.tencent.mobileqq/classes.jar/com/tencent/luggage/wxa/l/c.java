package com.tencent.luggage.wxa.l;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import java.io.EOFException;

public final class c
  implements l
{
  public int a(e parame, int paramInt, boolean paramBoolean)
  {
    paramInt = parame.a(paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    return paramInt;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, l.a parama) {}
  
  public void a(m paramm, int paramInt)
  {
    paramm.d(paramInt);
  }
  
  public void a(k paramk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.c
 * JD-Core Version:    0.7.0.1
 */