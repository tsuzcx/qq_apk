package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.z;
import com.tencent.ilinkservice.ao;
import com.tencent.luggage.wxa.dd.b.b;
import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.dd.d.d;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/LoginByTdiCloneSession;", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILogin;", "appId", "", "tdiCloneSession", "Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "(Ljava/lang/String;Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;)V", "getTdiCloneSession", "()Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "login", "", "callback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class e
  implements b.b
{
  public static final e.a a = new e.a(null);
  private final String b;
  @Nullable
  private final ao c;
  
  public e(@NotNull String paramString, @Nullable ao paramao)
  {
    this.b = paramString;
    this.c = paramao;
  }
  
  public void a(@NotNull b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "callback");
    if (this.c == null)
    {
      paramc.a((com.tencent.luggage.wxa.dd.d)d.d.b);
      return;
    }
    g localg = new g();
    localg.c(this.b);
    Object localObject = this.c.b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tdiCloneSession.userInfo");
    localg.b(new h(((b.z)localObject).g()).a());
    localg.a("LoginByTdiCloneSession");
    localObject = af.b("");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Util.nullAsNil(\"\")");
    localg.b((String)localObject);
    localg.c(2147483647);
    i.a.a(localg);
    ((d)com.tencent.luggage.wxa.ba.e.a(d.class)).a((b)new q(this.c));
    paramc.a(i.a.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.e
 * JD-Core Version:    0.7.0.1
 */