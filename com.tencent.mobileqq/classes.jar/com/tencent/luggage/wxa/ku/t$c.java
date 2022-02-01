package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t$c
  implements t.b
{
  t$c(u paramu, JSONArray paramJSONArray, int paramInt) {}
  
  public void a(@Nullable String paramString, @NotNull d.a[] paramArrayOfa, @NotNull boolean[] paramArrayOfBoolean, @NotNull Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfa, "scripts");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "results");
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "extras");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invoke with appId:");
    ((StringBuilder)localObject).append(this.b.getAppId());
    ((StringBuilder)localObject).append(" paths:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" key:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", results:");
    String str = Arrays.toString(paramArrayOfBoolean);
    Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
    ((StringBuilder)localObject).append(str);
    o.d("Luggage.WXA.JsApiLoadJsFiles", ((StringBuilder)localObject).toString());
    this.b.a(this.d, this.a.b("ok"));
    localObject = (t.b)this.b.d(t.b.class);
    if (localObject != null) {
      ((t.b)localObject).a(paramString, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t.c
 * JD-Core Version:    0.7.0.1
 */