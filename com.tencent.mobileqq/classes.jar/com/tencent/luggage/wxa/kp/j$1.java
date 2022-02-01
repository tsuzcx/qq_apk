package com.tencent.luggage.wxa.kp;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import java.lang.ref.WeakReference;

class j$1
  extends c.c
{
  j$1(j paramj, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void c()
  {
    e locale = (e)this.a.get();
    com.tencent.luggage.wxa.jx.e locale1 = (com.tencent.luggage.wxa.jx.e)this.b.get();
    if ((locale != null) && (locale1 != null))
    {
      locale1.b(locale);
      locale1.b(locale);
      locale1.b(locale);
      a.a().b(locale.getCameraId());
      c.b(locale1.getAppId(), this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.j.1
 * JD-Core Version:    0.7.0.1
 */