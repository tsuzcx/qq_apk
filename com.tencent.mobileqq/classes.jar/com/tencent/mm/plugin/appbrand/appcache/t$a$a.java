package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.storage.b;
import com.tencent.luggage.wxa.qw.lj;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetPublicLibInfoResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class t$a$a<T>
  implements e.c<lj>
{
  public static final a a = new a();
  
  public final void a(@Nullable lj paramlj)
  {
    if (paramlj != null)
    {
      boolean bool = ((ae)b.a(ae.class)).a(paramlj, null);
      String str = t.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CgiGetPublicInfo get resp: version:");
      localStringBuilder.append(paramlj.c);
      localStringBuilder.append(", md5:");
      localStringBuilder.append(paramlj.b);
      localStringBuilder.append(",  url:");
      localStringBuilder.append(paramlj.a);
      localStringBuilder.append(", patch_url:");
      localStringBuilder.append(paramlj.g);
      localStringBuilder.append(", dbUpdated:");
      localStringBuilder.append(bool);
      o.d(str, localStringBuilder.toString());
      t.b.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t.a.a
 * JD-Core Version:    0.7.0.1
 */