package com.tencent.luggage.wxa.dd;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/BaseAccountManager$login$1", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "onFail", "", "err", "Lcom/tencent/luggage/login/account/LoginErr;", "onSuccess", "sessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class a$a
  implements b.c
{
  a$a(b.c paramc) {}
  
  public void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "err");
    b.c localc = this.b;
    if (localc != null) {
      localc.a(paramd);
    }
  }
  
  public void a(@Nullable g paramg)
  {
    if (paramg == null)
    {
      paramg = this.b;
      if (paramg != null) {
        paramg.a((d)d.d.b);
      }
      return;
    }
    if (paramg.a() != null)
    {
      int i;
      if (((CharSequence)paramg.a()).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        this.a.a(paramg);
        this.a.c();
        paramg = this.b;
        if (paramg != null) {
          paramg.a(i.a.f());
        }
        return;
      }
    }
    paramg = this.b;
    if (paramg != null) {
      paramg.a((d)d.d.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.a.a
 * JD-Core Version:    0.7.0.1
 */