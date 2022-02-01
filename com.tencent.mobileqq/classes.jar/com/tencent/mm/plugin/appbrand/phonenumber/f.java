package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.hu;
import com.tencent.luggage.wxa.qw.hv;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  
  public f(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final void a(@Nullable Function1<? super hv, Unit> paramFunction1)
  {
    hu localhu = new hu();
    localhu.a = this.a;
    localhu.b = this.b;
    ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", this.a, (a)localhu, hv.class).a((com.tencent.luggage.wxa.rl.b)new f.a(paramFunction1)).a((e.a)new f.b(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f
 * JD-Core Version:    0.7.0.1
 */