package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.dc.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class n$a$a$1
  implements Runnable
{
  n$a$a$1(n.a.a parama, b paramb) {}
  
  public final void run()
  {
    int i;
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://long.open.weixin.qq.com/wxaruntime/qrconnect?uuid=");
      ((StringBuilder)localObject2).append(this.a.a.f());
      if (!this.a.a.d().get()) {
        break label757;
      }
      localObject1 = "&last=404";
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("long pulling url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      o.d("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject2).toString());
      localObject1 = new Request.Builder().url((String)localObject1).build();
      localObject1 = g.longConnectClient().newCall((Request)localObject1).execute().body();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((ResponseBody)localObject1).string();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("long pulling uuid = ");
      ((StringBuilder)localObject2).append(this.a.a.f());
      ((StringBuilder)localObject2).append(", resp = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      o.e("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject2).toString());
      localObject2 = n.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "respStr");
      localObject1 = n.a((n)localObject2, (String)localObject1);
      i = af.a((String)((Map)localObject1).get("window.wx_errcode"), -1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("long pulling uuid = ");
      ((StringBuilder)localObject2).append(this.a.a.f());
      ((StringBuilder)localObject2).append(", errcode = ");
      ((StringBuilder)localObject2).append(i);
      o.e("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject2).toString());
      if (i == 408) {
        break label739;
      }
      switch (i)
      {
      case 405: 
        label312:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unknown wx_errcode ");
        ((StringBuilder)localObject1).append(i);
        throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString()));
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("keepPulling uuid = ");
      ((StringBuilder)localObject2).append(this.a.a.f());
      ((StringBuilder)localObject2).append(", connect e = ");
      ((StringBuilder)localObject2).append(localException);
      o.b("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject2).toString());
      localObject2 = (n.b)this.a.a.b().get();
      if (localObject2 == null) {
        break label729;
      }
      ((n.b)localObject2).a(localException);
      n.a.a(this.a.a);
    }
    localObject1 = (String)((Map)localObject1).get("window.resp_data");
    localObject2 = (CharSequence)localObject1;
    if (localObject2 != null) {
      if (((CharSequence)localObject2).length() == 0)
      {
        break label771;
        label381:
        if (i == 0)
        {
          localObject2 = n.a;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = n.a((n)localObject2, StringsKt.replaceFirst$default((String)localObject1, "'{", "{", false, 4, null), "}'", "}");
          localObject2 = (n.b)this.a.a.b().get();
          if (localObject2 != null)
          {
            localObject1 = new i((String)localObject1).optString("data");
            if (localObject1 == null) {
              break label776;
            }
          }
        }
      }
    }
    for (;;)
    {
      ((n.b)localObject2).a((String)localObject1);
      n.a.a(this.a.a);
      break label739;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("long pulling uuid = ");
      ((StringBuilder)localObject1).append(this.a.a.f());
      ((StringBuilder)localObject1).append(", scanned");
      o.e("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject1).toString());
      this.a.a.d().set(true);
      localObject1 = (n.b)this.a.a.b().get();
      if (localObject1 != null)
      {
        ((n.b)localObject1).a();
        break label739;
        localObject1 = (n.b)this.a.a.b().get();
        if (localObject1 != null) {
          ((n.b)localObject1).c();
        }
        n.a.a(this.a.a);
        break label739;
        localObject1 = (n.b)this.a.a.b().get();
        if (localObject1 != null) {
          ((n.b)localObject1).b();
        }
        n.a.a(this.a.a);
      }
      label729:
      label739:
      this.b.a(new Object[] { null });
      return;
      label757:
      String str = "";
      break;
      break label312;
      i = 0;
      break label381;
      label771:
      i = 1;
      break label381;
      label776:
      str = "fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.n.a.a.1
 * JD-Core Version:    0.7.0.1
 */