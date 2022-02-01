package com.tencent.luggage.wxa.mw;

import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.kp.a;
import java.lang.ref.WeakReference;

class b$1
  extends c.c
{
  b$1(b paramb, WeakReference paramWeakReference, com.tencent.luggage.wxa.jx.e parame) {}
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (com.tencent.luggage.wxa.kp.e)((WeakReference)localObject).get();
      if (localObject != null)
      {
        this.b.b((f.d)localObject);
        this.b.b((f.b)localObject);
        this.b.b((f.c)localObject);
        a.a().b(((com.tencent.luggage.wxa.kp.e)localObject).getCameraId());
      }
    }
    c.b(this.b.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.b.1
 * JD-Core Version:    0.7.0.1
 */