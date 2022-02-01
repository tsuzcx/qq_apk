package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.dc.a;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.li;
import com.tencent.luggage.wxa.qw.lj;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibVersionChecker$CgiGetPublicInfo;", "Lcom/tencent/luggage/login/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetPublicLibInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetPublicLibInfoResponse;", "()V", "URL", "", "getURL", "()Ljava/lang/String;", "doCheck", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class t$a
  extends a<li, lj>
{
  public static final a a = new a();
  @NotNull
  private static final String b = "/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo";
  
  @NotNull
  public String a()
  {
    return b;
  }
  
  public final void b()
  {
    if (!i.a.g()) {
      return;
    }
    li localli = new li();
    localli.a = s.a.a().c();
    a(null, (gt)localli, lj.class).a((e.c)t.a.a.a).a((e.a)t.a.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t.a
 * JD-Core Version:    0.7.0.1
 */