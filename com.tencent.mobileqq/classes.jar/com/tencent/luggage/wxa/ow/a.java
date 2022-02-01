package com.tencent.luggage.wxa.ow;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qw.at;
import com.tencent.luggage.wxa.qw.au;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink;", "", "()V", "checkAsync", "", "shortLink", "", "businessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cgiSuccess", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "info", "Companion", "TYPE", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a.a a = new a.a(null);
  
  public final void a(@NotNull String paramString, @NotNull a.b paramb, @NotNull Function2<? super Boolean, ? super b, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "shortLink");
    Intrinsics.checkParameterIsNotNull(paramb, "businessType");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    at localat = new at();
    localat.b = paramb.ordinal();
    localat.a = paramString;
    paramString = e.a(com.tencent.luggage.wxa.ob.b.class);
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    ((com.tencent.luggage.wxa.ob.b)paramString).b("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", "", (com.tencent.luggage.wxa.qu.a)localat, au.class).a((com.tencent.luggage.wxa.rl.b)new a.c(paramFunction2)).a((e.a)new a.d(paramFunction2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ow.a
 * JD-Core Version:    0.7.0.1
 */