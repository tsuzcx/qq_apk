package com.tencent.luggage.wxa.kd;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class b$1
  implements Runnable
{
  b$1(b paramb, e parame, j paramj, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((!this.a.e()) && (!this.a.d()))
    {
      o.c("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
      return;
    }
    if (this.a.getCustomViewContainer() == null)
    {
      o.c("MicroMsg.BaseInsertViewJsApi", "fail, component custom view container is null");
      this.b.a(this.d.b("fail:insert view failed"));
      return;
    }
    for (;;)
    {
      try
      {
        i = this.d.a(this.c);
        localObject1 = this.d.a(this.a, this.c, i);
        if (localObject1 == null)
        {
          o.c("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
          this.b.a(this.d.b("fail:inflate view failed"));
          return;
        }
        bool4 = this.d.h(this.c);
        if (((localObject1 instanceof com.tencent.luggage.wxa.kt.b)) && (this.c.has("draggable")))
        {
          bool1 = this.d.i(this.c);
          localObject2 = (com.tencent.luggage.wxa.kt.b)localObject1;
          ((com.tencent.luggage.wxa.kt.b)localObject2).a(bool1, i, this.c.optString("data"));
          ((com.tencent.luggage.wxa.kt.b)localObject2).setDragConfig(this.d.j(this.c));
        }
        if (this.a.c(bool4).c(i))
        {
          o.c("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          this.b.a(this.d.b("fail:the view has already exist"));
          return;
        }
        j = this.d.b(this.c);
      }
      catch (JSONException localJSONException1)
      {
        int i;
        Object localObject1;
        boolean bool4;
        Object localObject2;
        int j;
        int k;
        Object localObject3;
        Boolean localBoolean1;
        Boolean localBoolean2;
        e.a locala;
        j localj;
        continue;
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
      }
      try
      {
        localObject2 = this.d.c(this.c);
        k = this.d.d(this.c);
        localObject3 = this.d.e(this.c);
        localBoolean1 = this.d.f(this.c);
        localBoolean2 = this.d.g(this.c);
        locala = this.a.c(bool4);
        if ((localObject3 == null) || (!((Boolean)localObject3).booleanValue())) {
          continue;
        }
        bool1 = true;
        if ((localBoolean1 == null) || (!localBoolean1.booleanValue())) {
          continue;
        }
        bool2 = true;
        if ((localBoolean2 == null) || (!localBoolean2.booleanValue())) {
          continue;
        }
        bool3 = true;
        bool1 = locala.a((View)localObject1, i, j, (float[])localObject2, k, bool1, bool2, bool3);
      }
      catch (JSONException localJSONException2)
      {
        o.b("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
        bool1 = false;
      }
    }
    bool2 = this.d.c();
    if (bool1)
    {
      b.a(this.d, this.a, i, (View)localObject1, this.c, bool4);
      if (bool2) {
        this.d.a(this.a, i, (View)localObject1, this.c, this.b);
      } else {
        this.d.a(this.a, i, (View)localObject1, this.c);
      }
    }
    b.a(this.d, this.a, i, bool4);
    o.d("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
    if (!bool2)
    {
      localj = this.b;
      localObject3 = this.d;
      if (bool1) {
        localObject1 = "ok";
      } else {
        localObject1 = "fail:insert view fail";
      }
      localj.a(((b)localObject3).b((String)localObject1));
    }
    return;
    this.b.a(this.d.b("fail:invalid view id"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.b.1
 * JD-Core Version:    0.7.0.1
 */