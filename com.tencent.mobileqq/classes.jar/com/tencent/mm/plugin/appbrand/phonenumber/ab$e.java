package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qw.hv;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"}, k=3, mv={1, 1, 16})
final class ab$e
  extends Lambda
  implements Function1<hv, Unit>
{
  ab$e(ab paramab, ProgressDialog paramProgressDialog, boolean paramBoolean)
  {
    super(1);
  }
  
  public final void a(@Nullable hv paramhv)
  {
    l.a((Runnable)new ab.e.1(this));
    if (paramhv == null)
    {
      o.b("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed");
      ab.b(this.a, "SendVerifyCode cgi fail");
      t.a((Runnable)new ab.e.2(this));
      return;
    }
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
    t.a((Runnable)new ab.e.3(this, paramhv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab.e
 * JD-Core Version:    0.7.0.1
 */