package com.tencent.luggage.wxa.kz;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class c$1
  implements Runnable
{
  c$1(c paramc, String paramString, com.tencent.luggage.wxa.jx.c paramc1, int paramInt1, WeakReference paramWeakReference, int paramInt2) {}
  
  public void run()
  {
    if ((!af.c(this.a)) && (this.a.startsWith("wxfile://"))) {
      localObject = new c.b(null);
    } else {
      localObject = new c.d(null);
    }
    Object localObject = ((c.c)localObject).a(this.b, this.a, this.c);
    if ((this.d.get() != null) && (((com.tencent.luggage.wxa.jx.c)this.d.get()).d()))
    {
      com.tencent.luggage.wxa.jx.c localc = (com.tencent.luggage.wxa.jx.c)this.d.get();
      if ((localObject != null) && ((((c.a)localObject).a) || (!af.c(((c.a)localObject).b))))
      {
        if (!((c.a)localObject).a)
        {
          o.c("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((c.a)localObject).b });
          localc.a(this.e, this.f.b(((c.a)localObject).b));
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((c.a)localObject).b);
        localc.a(this.e, this.f.a("ok", localHashMap));
        return;
      }
      o.c("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
      localc.a(this.e, this.f.b("fail:compress image fail"));
      return;
    }
    o.c("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.c.1
 * JD-Core Version:    0.7.0.1
 */