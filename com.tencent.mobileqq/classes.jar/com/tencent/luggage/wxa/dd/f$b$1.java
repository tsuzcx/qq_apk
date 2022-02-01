package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/SessionAccountManager$refreshSession$1$1", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "onFail", "", "err", "Lcom/tencent/luggage/login/account/LoginErr;", "onSuccess", "sessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class f$b$1
  implements b.c
{
  f$b$1(b paramb) {}
  
  public void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "err");
    String str = this.a.a.j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshSessionInfo fail, err:");
    localStringBuilder.append(paramd);
    o.b(str, localStringBuilder.toString());
    this.a.a.b();
    this.b.a(paramd);
  }
  
  public void a(@Nullable g paramg)
  {
    if (paramg != null)
    {
      f.a(this.a.a, paramg);
      this.b.a(new Object[] { f.a(this.a.a) });
      return;
    }
    o.b(this.a.a.j(), "refreshSessionInfo fail, sessionInfo is null");
    this.a.a.b();
    this.b.a("sessionInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.f.b.1
 * JD-Core Version:    0.7.0.1
 */