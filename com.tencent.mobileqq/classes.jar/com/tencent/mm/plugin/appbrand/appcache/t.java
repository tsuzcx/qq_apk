package com.tencent.mm.plugin.appbrand.appcache;

import android.app.Application;
import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.fq.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibVersionChecker;", "Lcom/tencent/luggage/wxaapi/internal/WxaPeriodTaskChecker;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "doCheck", "", "onInstalled", "application", "Landroid/app/Application;", "CgiGetPublicInfo", "WxaCommLibPkgDownloader", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class t
  extends n
{
  public static final t a = new t();
  @NotNull
  private static final String b = "Luggage.WxaCommLibVersionChecker";
  
  @NotNull
  public String a()
  {
    return b;
  }
  
  public void b()
  {
    t.a.a.b();
  }
  
  protected void b(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    super.b(paramApplication);
    i.a.a((b.a)new t.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */