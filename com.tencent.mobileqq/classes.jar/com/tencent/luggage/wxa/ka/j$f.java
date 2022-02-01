package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class j$f<T>
  implements e.a<Object>
{
  j$f(j paramj, b paramb, int paramInt, e parame, JSONObject paramJSONObject) {}
  
  public final void a(Object paramObject)
  {
    j.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onInterrupt, appId[");
    ((StringBuilder)localObject2).append(this.b.getAppId());
    ((StringBuilder)localObject2).append("], callbackId[");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("], e[");
    Object localObject1;
    if (paramObject != null) {
      localObject1 = paramObject.toString();
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(']');
    o.d("Luggage.WXA.JsApiOperateWXDataLU", ((StringBuilder)localObject2).toString());
    try
    {
      boolean bool = paramObject instanceof f.b;
      if (bool)
      {
        paramObject = this.d;
        if (paramObject != null) {
          paramObject.a();
        }
        return;
      }
      bool = paramObject instanceof f.a;
      int i;
      StringBuilder localStringBuilder;
      if (bool)
      {
        localObject1 = this.b;
        i = this.c;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail ");
        localStringBuilder.append(((f.a)paramObject).getMessage());
        ((b)localObject1).a(i, ((j)localObject2).b(localStringBuilder.toString()));
      }
      else if ((paramObject instanceof Throwable))
      {
        if (this.a.a(this.b, this.e, this.c, this.d, paramObject)) {
          return;
        }
        localObject1 = this.b;
        i = this.c;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail ");
        localStringBuilder.append(((Throwable)paramObject).getMessage());
        ((b)localObject1).a(i, ((j)localObject2).b(localStringBuilder.toString()));
      }
      else if (paramObject == null)
      {
        this.b.a(this.c, this.a.b("fail:internal error"));
      }
      else
      {
        localObject1 = this.b;
        i = this.c;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail ");
        localStringBuilder.append(paramObject);
        ((b)localObject1).a(i, ((j)localObject2).b(localStringBuilder.toString()));
      }
      paramObject = this.d;
      if (paramObject != null) {
        paramObject.a();
      }
      return;
    }
    finally
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        ((e)localObject1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.f
 * JD-Core Version:    0.7.0.1
 */