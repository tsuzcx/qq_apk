package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.el;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU$AuthInvoke$3$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h$b$1$b
  implements g
{
  public void a(int paramInt1, @NotNull ArrayList<String> paramArrayList, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "resultData");
    h.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dialog onMsg, resultCode[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], callbackId[");
    ((StringBuilder)localObject1).append(this.a.a.c);
    ((StringBuilder)localObject1).append(']');
    o.d("Luggage.WXA.JsApiAuthorizeLU", ((StringBuilder)localObject1).toString());
    paramArrayList = new h.b.1.b.a(this, paramArrayList, paramInt1);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        this.a.b.a(new f.a("fail:auth canceled"));
        return;
      }
      this.a.b.a(new f.a("fail:auth denied"));
      localObject1 = this.a.a.a;
      localObject2 = (com.tencent.luggage.wxa.jx.h)this.a.a.b;
      h.c();
      ((h)localObject1).a((com.tencent.luggage.wxa.jx.h)localObject2, "/cgi-bin/mmbiz-bin/js-authorize-confirm", (a)paramArrayList.a(), el.class);
      return;
    }
    localObject1 = this.a.a.a;
    Object localObject2 = this.a.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "m");
    h localh = this.a.a.a;
    com.tencent.luggage.wxa.jx.h localh1 = (com.tencent.luggage.wxa.jx.h)this.a.a.b;
    h.c();
    paramArrayList = localh.a(localh1, "/cgi-bin/mmbiz-bin/js-authorize-confirm", (a)paramArrayList.a(), el.class).b((com.tencent.luggage.wxa.rl.b)h.b.1.b.b.a);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "service.runCgi(CONFIRM_U…                        }");
    ((h)localObject1).a((com.tencent.luggage.wxa.ro.b)localObject2, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.b.1.b
 * JD-Core Version:    0.7.0.1
 */