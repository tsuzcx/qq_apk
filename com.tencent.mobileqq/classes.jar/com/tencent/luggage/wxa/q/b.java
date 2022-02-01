package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.g;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import java.util.Arrays;
import java.util.Collections;

final class b
  extends h
{
  private g a;
  private b.a b;
  
  public static boolean a(m paramm)
  {
    return (paramm.b() >= 5) && (paramm.g() == 127) && (paramm.l() == 1179402563L);
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  private int c(m paramm)
  {
    int i = (paramm.a[2] & 0xFF) >> 4;
    int j;
    switch (i)
    {
    default: 
      return -1;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      j = 256;
      i -= 8;
    case 6: 
    case 7: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return j << i;
        paramm.d(4);
        paramm.z();
        if (i == 6) {
          i = paramm.g();
        } else {
          i = paramm.h();
        }
        paramm.c(0);
        return i + 1;
        j = 576;
        i -= 2;
      }
    }
    return 192;
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.a = null;
      this.b = null;
    }
  }
  
  protected boolean a(m paramm, long paramLong, h.a parama)
  {
    byte[] arrayOfByte = paramm.a;
    if (this.a == null)
    {
      this.a = new g(arrayOfByte, 17);
      paramm = Arrays.copyOfRange(arrayOfByte, 9, paramm.c());
      paramm[4] = -128;
      paramm = Collections.singletonList(paramm);
      parama.a = k.a(null, "audio/flac", null, -1, this.a.a(), this.a.f, this.a.e, paramm, null, 0, null);
    }
    else if ((arrayOfByte[0] & 0x7F) == 3)
    {
      this.b = new b.a(this);
      this.b.a(paramm);
    }
    else if (a(arrayOfByte))
    {
      paramm = this.b;
      if (paramm != null)
      {
        paramm.c(paramLong);
        parama.b = this.b;
      }
      return false;
    }
    return true;
  }
  
  protected long b(m paramm)
  {
    if (!a(paramm.a)) {
      return -1L;
    }
    return c(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.b
 * JD-Core Version:    0.7.0.1
 */