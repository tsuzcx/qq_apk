package com.tencent.luggage.wxa.bu;

import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;

class a$6
  implements Runnable
{
  a$6(a parama, String paramString, com.github.henryye.nativeiv.api.a parama1) {}
  
  public void run()
  {
    synchronized (a.l(this.c))
    {
      if ((this.c.a) && (!a.l(this.c).contains(this.a)) && (this.b != null)) {
        if (this.c.b != 0)
        {
          if (a.l(this.c).size() < this.c.b)
          {
            o.e("MicroMsg.MBNiReporter", "reportDecodeInfo mMaxSampleNum report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(a.l(this.c).size()), this.b.a(), a.k(this.c), Integer.valueOf(this.c.d), Long.valueOf(this.b.b()), Long.valueOf(this.b.f()), Long.valueOf(this.b.g()) });
            a.a(this.c, this.a, this.b);
          }
        }
        else if (Math.random() < this.c.c)
        {
          o.e("MicroMsg.MBNiReporter", "reportDecodeInfo mSampleRate report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(a.l(this.c).size()), this.b.a(), a.k(this.c), Integer.valueOf(this.c.d), Long.valueOf(this.b.b()), Long.valueOf(this.b.f()), Long.valueOf(this.b.g()) });
          a.a(this.c, this.a, this.b);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a.6
 * JD-Core Version:    0.7.0.1
 */