package com.tencent.luggage.wxa.kd;

import android.view.View;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class d$1
  implements Runnable
{
  d$1(d paramd, WeakReference paramWeakReference, c paramc, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject2 = (e)this.a.get();
    if ((localObject2 != null) && (((e)localObject2).d())) {
      if (((e)localObject2).getCustomViewContainer() == null)
      {
        o.c("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
        this.b.a(this.c, this.e.b("fail:update view failed"));
        return;
      }
    }
    label385:
    try
    {
      i = this.e.a(this.d);
      bool3 = this.e.h(this.d);
      localObject1 = ((e)localObject2).c(bool3).b(i);
      if (localObject1 == null)
      {
        o.c("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
        this.b.a(this.c, this.e.b("fail:got 'null' when get view by the given viewId"));
        return;
      }
      if (((localObject1 instanceof b)) && (this.d.has("draggable")))
      {
        bool1 = this.e.i(this.d);
        localObject3 = (b)localObject1;
        ((b)localObject3).a(bool1, i);
        ((b)localObject3).setDragConfig(this.e.j(this.d));
      }
      d.a(this.e, (e)localObject2, i, (View)localObject1, this.d, bool3);
    }
    catch (JSONException localJSONException1)
    {
      int i;
      boolean bool3;
      Object localObject1;
      boolean bool1;
      Object localObject3;
      int j;
      Boolean localBoolean1;
      Boolean localBoolean2;
      e.a locala;
      boolean bool2;
      label383:
      break label514;
    }
    try
    {
      localObject3 = this.e.c(this.d);
      j = this.e.d(this.d);
      localBoolean1 = this.e.e(this.d);
      localBoolean2 = this.e.f(this.d);
      locala = ((e)localObject2).c(bool3);
      bool1 = true;
    }
    catch (JSONException localJSONException2)
    {
      break label383;
    }
    try
    {
      bool2 = locala.a(i, (float[])localObject3, j, localBoolean1, localBoolean2);
      o.d("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(((e)localObject2).c(bool3).d(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool2) });
      bool1 = bool2;
    }
    catch (JSONException localJSONException3)
    {
      break label385;
    }
    bool1 = true;
    bool3 = this.e.f();
    bool2 = bool1;
    if (bool1) {
      if (bool3) {
        bool2 = this.e.a((e)localObject2, i, (View)localObject1, this.d, new j(this.b, this.c));
      } else {
        bool2 = this.e.a((e)localObject2, i, (View)localObject1, this.d);
      }
    }
    if (!bool3)
    {
      localObject2 = this.b;
      i = this.c;
      localObject3 = this.e;
      if (bool2) {
        localObject1 = "ok";
      } else {
        localObject1 = "fail";
      }
      ((c)localObject2).a(i, ((d)localObject3).b((String)localObject1));
    }
    return;
    label514:
    this.b.a(this.c, this.e.b("fail:view id do not exist"));
    return;
    o.c("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
    this.b.a(this.c, this.e.b("fail:page is null"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.d.1
 * JD-Core Version:    0.7.0.1
 */