package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "invoke"}, k=3, mv={1, 1, 16})
final class v$a$a
  extends Lambda
  implements Function0<m.a>
{
  v$a$a(b paramb, String paramString1, String paramString2)
  {
    super(0);
  }
  
  @NotNull
  public final m.a a()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeSync filename(");
    localStringBuilder.append(this.c);
    localStringBuilder.append(") not found, appId:");
    localStringBuilder.append(this.a.getAppId());
    o.b(str, localStringBuilder.toString());
    return new m.a("fail:file doesn't exist", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.v.a.a
 * JD-Core Version:    0.7.0.1
 */