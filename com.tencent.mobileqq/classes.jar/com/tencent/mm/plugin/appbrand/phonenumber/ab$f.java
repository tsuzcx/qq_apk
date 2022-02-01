package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import com.tencent.luggage.wxa.qw.ay;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"}, k=3, mv={1, 1, 16})
final class ab$f
  extends Lambda
  implements Function1<ay, Unit>
{
  ab$f(ab paramab, ProgressDialog paramProgressDialog)
  {
    super(1);
  }
  
  public final void a(@Nullable ay paramay)
  {
    this.b.dismiss();
    if (paramay == null)
    {
      o.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed");
      ab.b(this.a, "checkVerifyCode cgi fail");
      z localz = this.a.c();
      if (localz != null)
      {
        paramay = this.a.c();
        if (paramay != null) {
          paramay = Long.valueOf(paramay.y());
        } else {
          paramay = null;
        }
        if (paramay == null) {
          Intrinsics.throwNpe();
        }
        localz.z(paramay.longValue() + 1L);
      }
      t.a((Runnable)new ab.f.1(this));
      return;
    }
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
    t.a((Runnable)new ab.f.2(this, paramay));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.f
 * JD-Core Version:    0.7.0.1
 */