package com.tencent.luggage.wxa.de;

import com.tencent.ilinkservice.ag.c;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.a;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.dd.h;
import com.tencent.luggage.wxa.dg.b;
import com.tencent.luggage.wxa.dg.b.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiAccountManager;", "Lcom/tencent/luggage/login/account/BaseAccountManager;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mSessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "mShare", "", "mTdiSessionCallback", "com/tencent/luggage/login/account/tdi/TdiAccountManager$mTdiSessionCallback$1", "Lcom/tencent/luggage/login/account/tdi/TdiAccountManager$mTdiSessionCallback$1;", "getSessionInfo", "getSessionKey", "hasLogin", "init", "", "share", "isShare", "loginSessionInfo", "sessionInfo", "logout", "onRequestUploadLogfiles", "ilinkPullLogCmd", "Lcom/tencent/ilinkservice/IlinkServiceProto$IlinkPullLogCmd;", "refreshSession", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "refreshSessionInfoSync", "release", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class f
  extends a
{
  public static final f.a a = new f.a(null);
  @NotNull
  private final String b = "ILink.TdiAccountManager";
  private boolean c;
  private g d;
  private f.b e = new f.b(this);
  
  public void a(@Nullable ag.c paramc) {}
  
  public void a(@Nullable g paramg)
  {
    if (paramg == null)
    {
      o.b(this.b, "loginSessionInfo err: sessionInfo is null");
      return;
    }
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginSessionInfo ");
    localStringBuilder.append(this.c);
    o.d(str, localStringBuilder.toString());
    if (this.c)
    {
      h.b.a(paramg.a());
      h.b.b(paramg.c());
      h.b.b(paramg.d());
      h.b.c(paramg.e());
      h.b.c(paramg.f());
      h.b.a(paramg.b());
    }
    else
    {
      this.d = paramg;
    }
    ((b)e.a(b.class)).a((b.b)this.e);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init ");
    localStringBuilder.append(this.c);
    o.d(str, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    o.d(this.b, "logout");
    if (this.c) {
      h.b.j();
    } else {
      this.d = ((g)null);
    }
    ((b)e.a(b.class)).g();
    ((d)e.a(d.class)).a();
    super.b();
  }
  
  @NotNull
  public String e()
  {
    Object localObject = f();
    if (localObject != null)
    {
      localObject = ((g)localObject).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public g f()
  {
    if (this.c) {
      return (g)h.b;
    }
    return this.d;
  }
  
  public boolean g()
  {
    return af.c(e()) ^ true;
  }
  
  public boolean h()
  {
    return false;
  }
  
  @NotNull
  public final String i()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.f
 * JD-Core Version:    0.7.0.1
 */