package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.ax;
import com.tencent.luggage.wxa.qw.ay;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCodeWxaPhone;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public c(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public final void a(@Nullable Function1<? super ay, Unit> paramFunction1)
  {
    ax localax = new ax();
    localax.a = this.a;
    localax.b = this.b;
    localax.c = this.c;
    ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", this.a, (a)localax, ay.class).a((com.tencent.luggage.wxa.rl.b)new c.a(paramFunction1)).a((e.a)new c.b(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.c
 * JD-Core Version:    0.7.0.1
 */