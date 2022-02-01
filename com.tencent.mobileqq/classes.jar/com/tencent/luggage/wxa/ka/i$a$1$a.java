package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.ep;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU$AuthInvoke$2$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$Listener;", "onRecvMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class i$a$1$a
  implements c.a
{
  public void a(int paramInt, @Nullable ArrayList<String> paramArrayList)
  {
    i.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dialog onRecvMsg, resultCode[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("], callbackId[");
    ((StringBuilder)localObject1).append(this.a.a.c);
    ((StringBuilder)localObject1).append(']');
    o.d("Luggage.WXA.JsApiLoginLU", ((StringBuilder)localObject1).toString());
    paramArrayList = new i.a.1.a.a(this, paramArrayList, paramInt);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        this.a.b.a(new f.a("fail:auth canceled"));
        return;
      }
      this.a.b.a(new f.a("fail:auth denied"));
      localObject1 = this.a.a.a;
      localObject2 = (h)this.a.a.b;
      i.c();
      ((i)localObject1).a((h)localObject2, "/cgi-bin/mmbiz-bin/js-login-confirm", (a)paramArrayList.a(), ep.class);
      return;
    }
    localObject1 = this.a.a.a;
    Object localObject2 = this.a.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "m");
    i locali = this.a.a.a;
    h localh = (h)this.a.a.b;
    i.c();
    paramArrayList = locali.a(localh, "/cgi-bin/mmbiz-bin/js-login-confirm", (a)paramArrayList.a(), ep.class).b((com.tencent.luggage.wxa.rl.b)i.a.1.a.b.a);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "service.runCgi(CONFIRM_U…                        }");
    ((i)localObject1).a((com.tencent.luggage.wxa.ro.b)localObject2, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.a.1.a
 * JD-Core Version:    0.7.0.1
 */