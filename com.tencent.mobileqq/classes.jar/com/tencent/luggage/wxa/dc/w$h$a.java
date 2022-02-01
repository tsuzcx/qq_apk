package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.dd.d;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/WxaTdiLoginBoot$userAutoLoginForMainProcess$1$onLoginComplete$1", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "onFail", "", "err", "Lcom/tencent/luggage/login/account/LoginErr;", "onSuccess", "sessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class w$h$a
  implements b.c
{
  public void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "err");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail:login fail, err=(");
    ((StringBuilder)localObject).append(paramd.a());
    ((StringBuilder)localObject).append(',');
    ((StringBuilder)localObject).append(paramd.b());
    ((StringBuilder)localObject).append(',');
    ((StringBuilder)localObject).append(paramd.c());
    ((StringBuilder)localObject).append(')');
    paramd = ((StringBuilder)localObject).toString();
    this.a.b.invoke(Integer.valueOf(-1), paramd);
    localObject = w.b(w.a);
    if (localObject != null) {
      paramd = (Unit)((Function2)localObject).invoke(Boolean.valueOf(false), paramd);
    }
  }
  
  public void a(@Nullable g paramg)
  {
    o.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot: step 3: login success");
    this.a.b.invoke(Integer.valueOf(0), "");
    paramg = w.b(w.a);
    if (paramg != null) {
      paramg = (Unit)paramg.invoke(Boolean.valueOf(true), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.h.a
 * JD-Core Version:    0.7.0.1
 */