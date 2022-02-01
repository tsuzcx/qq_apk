package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class i$d<T>
  implements e.a<Object>
{
  i$d(i parami, e parame, b paramb, int paramInt) {}
  
  public final void a(Object paramObject)
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((e)localObject1).a();
    }
    i.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onInterrupt, appId[");
    ((StringBuilder)localObject2).append(this.c.getAppId());
    ((StringBuilder)localObject2).append("], callbackId[");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append("], e[");
    if (paramObject != null) {
      localObject1 = paramObject.toString();
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(']');
    o.d("Luggage.WXA.JsApiLoginLU", ((StringBuilder)localObject2).toString());
    if ((paramObject instanceof f.b)) {
      return;
    }
    if ((paramObject instanceof f.a))
    {
      localObject1 = this.c;
      i = this.d;
      localObject2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail ");
      localStringBuilder.append(((f.a)paramObject).getMessage());
      ((b)localObject1).a(i, ((i)localObject2).b(localStringBuilder.toString()));
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      localObject1 = this.c;
      i = this.d;
      localObject2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail ");
      localStringBuilder.append(((Throwable)paramObject).getMessage());
      ((b)localObject1).a(i, ((i)localObject2).b(localStringBuilder.toString()));
      return;
    }
    if (paramObject == null)
    {
      this.c.a(this.d, this.a.b("fail:internal error"));
      return;
    }
    localObject1 = this.c;
    int i = this.d;
    localObject2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail ");
    localStringBuilder.append(paramObject);
    ((b)localObject1).a(i, ((i)localObject2).b(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.d
 * JD-Core Version:    0.7.0.1
 */