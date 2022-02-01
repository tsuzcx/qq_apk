package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/SessionAccountManager;", "Lcom/tencent/luggage/login/account/BaseAccountManager;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOURIST_SESSION_INFO", "Lcom/tencent/luggage/login/account/SessionInfo;", "value", "mSessionInfo", "setMSessionInfo", "(Lcom/tencent/luggage/login/account/SessionInfo;)V", "mShare", "", "getSessionInfo", "getSessionKey", "hasLogin", "init", "", "share", "isShare", "loginSessionInfo", "sessionInfo", "logout", "refreshSession", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "refreshSessionInfoSync", "release", "const", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class f
  extends a
{
  public static final f.a a = new f.a(null);
  private final g b;
  private boolean c;
  private g d;
  @NotNull
  private final String e;
  
  public f()
  {
    g localg = new g();
    localg.a("");
    localg.a(-1);
    localg.b(0);
    localg.b("");
    localg.c("");
    localg.c(-1);
    localg.d("");
    this.b = localg;
    this.c = true;
    this.d = this.b;
    this.e = "Luggage.WxaAccountManager";
  }
  
  private final void b(g paramg)
  {
    if (this.c)
    {
      h.b.a(paramg.a());
      h.b.b(paramg.c());
      h.b.b(paramg.d());
      h.b.c(paramg.e());
      h.b.c(paramg.f());
      h.b.a(paramg.b());
      h.b.d(paramg.g());
      this.d = ((g)h.b);
      return;
    }
    this.d = new g(paramg.e(), paramg.c(), paramg.a(), paramg.d(), paramg.f(), paramg.g());
  }
  
  public void a(@Nullable g paramg)
  {
    if (paramg == null) {
      paramg = this.b;
    }
    b(paramg);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.c)
    {
      b((g)h.b);
      if (r.h()) {
        i();
      }
    }
    else
    {
      b(this.b);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    b(this.b);
    super.b();
  }
  
  @NotNull
  public String e()
  {
    return this.d.a();
  }
  
  @NotNull
  public g f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return af.c(e()) ^ true;
  }
  
  public boolean h()
  {
    boolean bool2 = g();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    g localg = f();
    if (localg.i() <= 0) {
      return true;
    }
    localg = c.a.a(localg);
    if (localg != null)
    {
      b(localg);
      bool1 = true;
    }
    return bool1;
  }
  
  @NotNull
  public d<g> i()
  {
    d locald = com.tencent.luggage.wxa.ro.h.a().b((b)new f.b(this));
    Intrinsics.checkExpressionValueIsNotNull(locald, "pipeline().`$logic` {\n  …  SessionInfo()\n        }");
    return locald;
  }
  
  @NotNull
  public final String j()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.f
 * JD-Core Version:    0.7.0.1
 */