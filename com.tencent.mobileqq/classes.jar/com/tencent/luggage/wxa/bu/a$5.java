package com.tencent.luggage.wxa.bu;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.CopyOnWriteArrayList;

class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public void run()
  {
    long l1 = a.g(this.a) - a.h(this.a);
    long l2 = (af.b() - a.g(this.a)) / 1000L;
    float f;
    if ((l2 > 0L) && (l2 < 10L))
    {
      if (a.c(this.a) != null)
      {
        f = a.c(this.a).a(a.d(this.a));
      }
      else
      {
        d = -1.0D;
        break label99;
      }
    }
    else {
      f = a.i(this.a);
    }
    double d = f;
    label99:
    a.c localc = new a.c(this.a);
    if ((a.a(this.a).size() > 0) && (a.b(this.a) > 0))
    {
      localObject = this.a;
      a.a((a)localObject, localc, a.a((a)localObject));
    }
    Object localObject = new a.b(this.a);
    if (a.a(this.a).size() > 0)
    {
      a locala = this.a;
      a.a(locala, (a.b)localObject, a.a(locala));
    }
    a.a(this.a, 0);
    a.a(this.a).clear();
    a.j(this.a);
    o.d("MicroMsg.MBNiReporter", "hy: decode performance appid:%s,inject2firstDraw:%d,firstFps:%f,PreDecodeNum:%d,PreDecodeTotalTime:%d,preDecodeAvgTime:%f,totalDecodeNum:%d,totalDecodeTime:%d,totalDecodeAvgTime:%f", new Object[] { a.k(this.a), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localc.a), Long.valueOf(localc.b), Double.valueOf(localc.c), Integer.valueOf(((a.b)localObject).a), Long.valueOf(((a.b)localObject).b), Double.valueOf(((a.b)localObject).c) });
    if (l1 > 0L) {
      ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(16136, new Object[] { a.k(this.a), Long.valueOf(l1), Double.valueOf(d), Integer.valueOf(localc.a), Long.valueOf(localc.b), Double.valueOf(localc.c), Integer.valueOf(((a.b)localObject).a), Long.valueOf(((a.b)localObject).b), Double.valueOf(((a.b)localObject).c) });
    }
    a.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a.5
 * JD-Core Version:    0.7.0.1
 */