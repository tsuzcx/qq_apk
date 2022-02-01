package com.tencent.luggage.wxa.dc;

import com.tencent.ilink.tdi.b.v;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.de.e;
import com.tencent.luggage.wxa.dg.b;
import com.tencent.luggage.wxa.dg.b.b;
import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/WxaTdiLoginBoot$userAutoLoginForMainProcess$1", "Lcom/tencent/luggage/login/device/IActivateDevice$TdiSessionCallbackWrapper;", "onLoginComplete", "", "errCode", "", "tdiLoginResponse", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginResponse;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class w$h
  extends b.b
{
  w$h(b paramb, Function2 paramFunction2) {}
  
  public void a(int paramInt, @Nullable b.v paramv)
  {
    this.a.b((b.b)this);
    paramv = new StringBuilder();
    paramv.append("Wxa login logic boot: step 3: onLoginComplete errCode:");
    paramv.append(paramInt);
    o.d("Luggage.WxaTdiLoginBoot", paramv.toString());
    int i = 0;
    paramv = Boolean.valueOf(false);
    if (paramInt == 0) {
      i = 1;
    }
    if (i != 0)
    {
      paramv = this.a.f().a();
      if (paramv != null)
      {
        o.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot: step 3.1: createCloneSession success");
        new e(d.a.d(), paramv).a((b.c)new w.h.a(this));
      }
    }
    else
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail:autoLogin fail, errCode=");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      Function2 localFunction2;
      if (paramInt > 0)
      {
        this.b.invoke(Integer.valueOf(-2), localObject);
        localFunction2 = w.b(w.a);
        if (localFunction2 != null) {
          paramv = (Unit)localFunction2.invoke(paramv, localObject);
        }
      }
      else
      {
        this.b.invoke(Integer.valueOf(-1), localObject);
        localFunction2 = w.b(w.a);
        if (localFunction2 != null) {
          paramv = (Unit)localFunction2.invoke(paramv, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.h
 * JD-Core Version:    0.7.0.1
 */