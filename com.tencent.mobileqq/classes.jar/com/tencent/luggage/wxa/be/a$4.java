package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kp.g;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class a$4
  implements d.b
{
  a$4(a parama) {}
  
  public void a()
  {
    this.a.b = true;
    o.d("MicroMsg.AppBrandCameraView", "InitDoneCallback");
    g localg = new g();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(a.f(this.a)));
    Object localObject;
    if (a.h(this.a) != null) {
      localObject = a.h(this.a).i();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (localObject.length > 0)) {
      a.a(this.a, localObject[(localObject.length - 1)]);
    }
    localHashMap.put("maxZoom", Float.valueOf(a.i(this.a)));
    localg.b(new JSONObject(localHashMap).toString());
    a.g(this.a).a(localg, null);
    if (a.j(this.a) != null)
    {
      localObject = a.j(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
      a.j(this.a).clear();
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.4
 * JD-Core Version:    0.7.0.1
 */