package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.es;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class j$c$1$c
  implements g
{
  public void a(int paramInt1, @NotNull ArrayList<String> paramArrayList, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "resultData");
    j.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dialog onMsg, resultCode[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], callbackId[");
    ((StringBuilder)localObject1).append(this.a.a.c);
    ((StringBuilder)localObject1).append(']');
    o.d("Luggage.WXA.JsApiOperateWXDataLU", ((StringBuilder)localObject1).toString());
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        this.a.b.a(new f.a("fail:auth canceled"));
        return;
      }
      this.a.b.a(new f.a("fail:auth denied"));
      paramArrayList = this.a.a.d.a();
      paramArrayList.d = 2;
      localObject1 = this.a.a.a;
      localObject2 = (h)this.a.a.b;
      j.c();
      ((j)localObject1).a((h)localObject2, "/cgi-bin/mmbiz-bin/js-operatewxdata", (a)paramArrayList, et.class);
      return;
    }
    localObject1 = this.a.a.d.a();
    ((es)localObject1).d = 1;
    ((es)localObject1).c = ((String)CollectionsKt.firstOrNull((List)paramArrayList));
    paramArrayList = this.a.a.a;
    Object localObject2 = this.a.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "m");
    j localj = this.a.a.a;
    h localh = (h)this.a.a.b;
    j.c();
    paramArrayList.a((b)localObject2, localj.a(localh, "/cgi-bin/mmbiz-bin/js-operatewxdata", (a)localObject1, et.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.c.1.c
 * JD-Core Version:    0.7.0.1
 */