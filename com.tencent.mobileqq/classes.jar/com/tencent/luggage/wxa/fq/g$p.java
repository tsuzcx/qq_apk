package com.tencent.luggage.wxa.fq;

import android.content.Context;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.mm.plugin.appbrand.shortlink.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaApiImpl$launchWxaByShortLink$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "judgeIsLaunchSuccess", "", "ret", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$p
  extends a<LaunchWxaAppResult>
{
  g$p(String paramString, Map paramMap) {}
  
  @NotNull
  protected com.tencent.luggage.wxa.ow.a.b a()
  {
    return com.tencent.luggage.wxa.ow.a.b.c;
  }
  
  protected void a(@NotNull Context paramContext, @NotNull com.tencent.mm.plugin.appbrand.shortlink.a.b paramb, @NotNull Function1<? super LaunchWxaAppResult, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramb, "params");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "launchResultCallback");
    g.a(this.a, paramContext, paramb.a(), paramb.c(), paramb.b(), this.b, this.c, (LaunchWxaAppResultListener)new g.p.a(paramFunction1));
  }
  
  protected boolean a(@NotNull LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    Intrinsics.checkParameterIsNotNull(paramLaunchWxaAppResult, "ret");
    return paramLaunchWxaAppResult == LaunchWxaAppResult.OK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.p
 * JD-Core Version:    0.7.0.1
 */