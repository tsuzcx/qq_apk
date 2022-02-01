package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncResponse;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class k$a$1<T>
  implements e.c<lv>
{
  k$a$1(k.a parama, b paramb, Ref.ObjectRef paramObjectRef) {}
  
  public final void a(lv paramlv)
  {
    s locals = null;
    StringBuilder localStringBuilder = null;
    if (paramlv != null) {
      localObject = paramlv.z;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = paramlv.z;
      if ((localObject != null) && (((aa)localObject).a == 0))
      {
        u.a().b(this.a.a, paramlv);
        localObject = this.c;
        locals = u.a().a(this.a.a, new String[] { "appId" });
        paramlv = localStringBuilder;
        if (locals != null) {
          paramlv = locals.d;
        }
        ((Ref.ObjectRef)localObject).element = paramlv;
        paramlv = (CharSequence)this.c.element;
        int i;
        if ((paramlv != null) && (paramlv.length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          o.b("Luggage.WxaAttrSyncHelper", "getAppIdByUserName fail, appId is null");
          this.b.a("getAppIdByUserName fail, appId is null");
          return;
        }
        this.b.a(new Object[] { (String)this.c.element });
        return;
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppIdByUserName fail, response:");
    Object localObject = paramlv.z;
    if (localObject != null) {
      localObject = Integer.valueOf(((aa)localObject).a);
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" is null");
    o.b("Luggage.WxaAttrSyncHelper", localStringBuilder.toString());
    localObject = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppIdByUserName fail, response:");
    aa localaa = paramlv.z;
    paramlv = locals;
    if (localaa != null) {
      paramlv = Integer.valueOf(localaa.a);
    }
    localStringBuilder.append(paramlv);
    localStringBuilder.append(" is null");
    ((b)localObject).a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.k.a.1
 * JD-Core Version:    0.7.0.1
 */