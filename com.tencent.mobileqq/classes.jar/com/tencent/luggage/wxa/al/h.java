package com.tencent.luggage.wxa.al;

import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.u;
import com.tencent.luggage.wxa.z.o;

public final class h
{
  public final o a;
  public final f b;
  public final Object c;
  public final u[] d;
  
  public h(o paramo, f paramf, Object paramObject, u[] paramArrayOfu)
  {
    this.a = paramo;
    this.b = paramf;
    this.c = paramObject;
    this.d = paramArrayOfu;
  }
  
  public boolean a(h paramh)
  {
    if (paramh == null) {
      return false;
    }
    int i = 0;
    while (i < this.b.a)
    {
      if (!a(paramh, i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean a(h paramh, int paramInt)
  {
    boolean bool2 = false;
    if (paramh == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (x.a(this.b.a(paramInt), paramh.b.a(paramInt)))
    {
      bool1 = bool2;
      if (x.a(this.d[paramInt], paramh.d[paramInt])) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.h
 * JD-Core Version:    0.7.0.1
 */