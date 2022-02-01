package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qw.hv;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"}, k=3, mv={1, 1, 16})
final class t$d
  extends Lambda
  implements Function1<hv, Unit>
{
  t$d(t paramt, ProgressDialog paramProgressDialog)
  {
    super(1);
  }
  
  public final void a(@Nullable hv paramhv)
  {
    String str = t.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendSms success");
    boolean bool;
    if (paramhv != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    o.d(str, localStringBuilder.toString());
    if (paramhv != null)
    {
      o.d(t.a.a(), "sendSms:%d", new Object[] { Integer.valueOf(paramhv.a) });
      com.tencent.luggage.wxa.qz.t.a((Runnable)new t.d.1(this, paramhv));
    }
    else
    {
      com.tencent.luggage.wxa.qz.t.a((Runnable)new t.d.2(this));
    }
    l.a((Runnable)new t.d.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.d
 * JD-Core Version:    0.7.0.1
 */