package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qw.ay;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"}, k=3, mv={1, 1, 16})
final class t$f
  extends Lambda
  implements Function1<ay, Unit>
{
  t$f(t paramt, boolean paramBoolean, String paramString, ProgressDialog paramProgressDialog)
  {
    super(1);
  }
  
  public final void a(@Nullable ay paramay)
  {
    String str = t.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("verifyCode success:");
    boolean bool;
    if (paramay != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    o.d(str, localStringBuilder.toString());
    if (paramay != null)
    {
      o.d(t.a.a(), "checkVerifyCode:%d", new Object[] { Integer.valueOf(paramay.a) });
      com.tencent.luggage.wxa.qz.t.a((Runnable)new t.f.1(this, paramay));
    }
    else
    {
      com.tencent.luggage.wxa.qz.t.a((Runnable)new t.f.2(this));
    }
    l.a((Runnable)new t.f.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.f
 * JD-Core Version:    0.7.0.1
 */