package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import java.lang.ref.WeakReference;
import java.util.List;

class h$1
  implements Runnable
{
  h$1(h paramh, WeakReference paramWeakReference, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    com.tencent.luggage.wxa.jx.h localh = (com.tencent.luggage.wxa.jx.h)this.a.get();
    if (localh == null) {
      return;
    }
    Object[] arrayOfObject = ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(localh.getAppId()).b(this.b, localh.getAppId());
    List localList = (List)arrayOfObject[0];
    int i = (int)Math.ceil(((Integer)arrayOfObject[1]).doubleValue() / 1000.0D);
    int j = (int)Math.ceil(((Integer)arrayOfObject[2]).doubleValue() / 1000.0D);
    h.a(this.e, localList, i, j, localh, this.c);
    h.a(this.e, 2, localList, i * 1000, this.d, localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.h.1
 * JD-Core Version:    0.7.0.1
 */