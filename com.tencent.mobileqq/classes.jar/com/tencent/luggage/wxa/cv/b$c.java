package com.tencent.luggage.wxa.cv;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qw.du;
import com.tencent.luggage.wxa.qw.dw;
import com.tencent.luggage.wxa.qw.dx;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "verifyResponse", "Lcom/tencent/mm/protocal/protobuf/JSAPIAuthResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$c<T>
  implements e.c<dx>
{
  b$c(b paramb, m paramm, String paramString, Function0 paramFunction01, Function0 paramFunction02, dw paramdw) {}
  
  public final void a(@Nullable dx paramdx)
  {
    if (paramdx != null) {
      localObject1 = paramdx.b;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      b.a();
      paramdx = new StringBuilder();
      paramdx.append("doJSAuthVerify get NULL resp.auth_info with api:");
      paramdx.append(this.b.d());
      paramdx.append(", url:");
      paramdx.append(this.c);
      o.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", paramdx.toString());
      this.d.invoke();
      return;
    }
    Object localObject1 = paramdx.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "verifyResponse.auth_info");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localdu = (du)((Iterator)localObject1).next();
      Map localMap = (Map)b.b(this.a);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append(localdu.a);
      localObject2 = ((StringBuilder)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localdu, "authInfo");
      localMap.put(localObject2, localdu);
    }
    du localdu = (du)b.b(this.a).get(b.a(this.a, this.c, this.b.d()));
    if (localdu != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localdu, "JSAuthCache[makeJSAuthKe…rminate onReject.invoke()");
      int i = localdu.b;
      b.a();
      if (i == 1)
      {
        this.e.invoke();
        return;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.widget.dialog.b(b.c(this.a).getContext());
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setMessage((CharSequence)localdu.c);
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setPositiveButton((CharSequence)b.c(this.a).getContext().getString(2131890779), true, (DialogInterface.OnClickListener)new b.c.1(this, localdu, paramdx));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setNegativeButton((CharSequence)b.c(this.a).getContext().getString(2131890778), true, (DialogInterface.OnClickListener)new b.c.2(this));
      paramdx = b.c(this.a).getDialogContainer();
      if (paramdx == null) {
        Intrinsics.throwNpe();
      }
      paramdx.a((i)localObject1);
      return;
    }
    this.d.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.c
 * JD-Core Version:    0.7.0.1
 */