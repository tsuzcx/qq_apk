package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class k$a<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  k$a(String paramString) {}
  
  @Nullable
  public final String a(Void paramVoid)
  {
    paramVoid = (CharSequence)this.a;
    int j = 1;
    int i;
    if ((paramVoid != null) && (paramVoid.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      com.tencent.luggage.wxa.qz.o.c("Luggage.WxaAttrSyncHelper", "username is null, return");
      return "";
    }
    paramVoid = this.a;
    Object localObject = null;
    if (!StringsKt.endsWith$default(paramVoid, "@app", false, 2, null))
    {
      paramVoid = new StringBuilder();
      paramVoid.append(this.a);
      paramVoid.append("@app");
      paramVoid = paramVoid.toString();
    }
    else
    {
      paramVoid = this.a;
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    s locals = u.a().a(this.a, new String[] { "appId" });
    if (locals != null) {
      localObject = locals.d;
    }
    localObjectRef.element = localObject;
    if ((String)localObjectRef.element != null)
    {
      if (((CharSequence)localObjectRef.element).length() > 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramVoid = new StringBuilder();
        paramVoid.append(this.a);
        paramVoid.append(" getAppIdByUserName by cache success: ");
        paramVoid.append((String)localObjectRef.element);
        com.tencent.luggage.wxa.qz.o.b("Luggage.WxaAttrSyncHelper", paramVoid.toString());
        return (String)localObjectRef.element;
      }
    }
    localObject = h.c();
    com.tencent.luggage.wxa.dc.o.d(paramVoid).a((e.c)new k.a.1(this, (com.tencent.luggage.wxa.ro.b)localObject, localObjectRef)).a((e.a)new k.a.2((com.tencent.luggage.wxa.ro.b)localObject));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.k.a
 * JD-Core Version:    0.7.0.1
 */