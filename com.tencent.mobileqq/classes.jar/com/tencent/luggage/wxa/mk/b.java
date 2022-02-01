package com.tencent.luggage.wxa.mk;

import com.tencent.luggage.wxa.p.e;
import com.tencent.luggage.wxa.r.p;
import com.tencent.luggage.wxa.r.u;
import java.lang.reflect.Constructor;

public final class b
  implements com.tencent.luggage.wxa.l.g
{
  private static final Constructor<? extends com.tencent.luggage.wxa.l.d> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = 1;
  private int g;
  
  static
  {
    try
    {
      localConstructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(com.tencent.luggage.wxa.l.d.class).getConstructor(new Class[0]);
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      Constructor localConstructor;
      label21:
      break label21;
    }
    localConstructor = null;
    a = localConstructor;
  }
  
  public com.tencent.luggage.wxa.l.d[] a()
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          i = 11;
          com.tencent.luggage.wxa.l.d[] arrayOfd = new com.tencent.luggage.wxa.l.d[i];
          arrayOfd[0] = new com.tencent.luggage.wxa.p.g(this.c);
          arrayOfd[1] = new u(this.f, this.g);
          arrayOfd[2] = new e(this.d);
          arrayOfd[3] = new com.tencent.luggage.wxa.o.b(this.e);
          arrayOfd[4] = new com.tencent.luggage.wxa.n.d(this.b);
          arrayOfd[5] = new com.tencent.luggage.wxa.r.c();
          arrayOfd[6] = new com.tencent.luggage.wxa.r.a();
          arrayOfd[7] = new com.tencent.luggage.wxa.m.b();
          arrayOfd[8] = new com.tencent.luggage.wxa.q.c();
          arrayOfd[9] = new p();
          arrayOfd[10] = new com.tencent.luggage.wxa.s.a();
          Constructor localConstructor = a;
          if (localConstructor != null) {
            try
            {
              arrayOfd[11] = ((com.tencent.luggage.wxa.l.d)a.newInstance(new Object[0]));
            }
            catch (Exception localException)
            {
              throw new IllegalStateException("Unexpected error creating FLAC extractor", localException);
            }
          }
          return localException;
        }
      }
      finally {}
      int i = 12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.b
 * JD-Core Version:    0.7.0.1
 */