package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.is;
import com.tencent.luggage.wxa.qw.it;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
{
  public static final g.a a = new g.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  private final int d;
  
  public g(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public final void a(@Nullable Function1<? super it, Unit> paramFunction1)
  {
    is localis = new is();
    localis.a = this.b;
    localis.b = this.c;
    localis.c = this.d;
    ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", this.b, (a)localis, it.class).a((com.tencent.luggage.wxa.rl.b)new g.b(paramFunction1)).a((e.a)new g.c(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */