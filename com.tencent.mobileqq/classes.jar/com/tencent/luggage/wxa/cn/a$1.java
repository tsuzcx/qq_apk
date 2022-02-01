package com.tencent.luggage.wxa.cn;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

class a$1
  implements Runnable
{
  a$1(a parama, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = (String)a.n_().get();
    Object localObject1 = localObject3;
    Object localObject4;
    Object localObject2;
    if (af.c((String)localObject3)) {
      try
      {
        localObject4 = af.a(r.a().getAssets().open("address"));
        localObject3 = localObject4;
        localObject1 = localObject4;
        if (!af.c((String)localObject4))
        {
          localObject3 = localObject4;
          a.n_().set(localObject4);
          localObject1 = localObject4;
        }
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.AppBrand.JsApiGetRegionData", localException, "read address from assets", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject3 = (u)this.a.get();
    if ((localObject3 != null) && (((u)localObject3).d()))
    {
      localObject4 = new HashMap(1);
      ((Map)localObject4).put("data", localObject2);
      ((u)localObject3).a(this.b, this.c.a("ok", (Map)localObject4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cn.a.1
 * JD-Core Version:    0.7.0.1
 */