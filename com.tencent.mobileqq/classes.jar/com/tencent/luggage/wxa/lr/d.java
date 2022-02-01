package com.tencent.luggage.wxa.lr;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons-jsapi-default-impl_release"}, k=2, mv={1, 1, 16})
public final class d
{
  @Nullable
  public static final String a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @NotNull b paramb, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "referrerPolicyContainer");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      return null;
    }
    a locala = (a)e.a(a.class);
    if (locala == null)
    {
      o.c("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.a());
    }
    paramJSONObject = locala.a(paramJSONObject, paramc);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("updateReferrers, referrerPolicy: ");
    paramJSONObject.append(paramb.getReferrerPolicy());
    o.d("MicroMsg.AppBrand.Referrers", paramJSONObject.toString());
    if (c.b == paramb.getReferrerPolicy()) {
      return null;
    }
    paramc = locala.b(paramc);
    paramb = new StringBuilder();
    paramb.append("updateReferrers, mReferrer: ");
    paramb.append(paramc);
    o.d("MicroMsg.AppBrand.Referrers", paramb.toString());
    return paramc;
  }
  
  @Nullable
  public static final Map<String, String> a(@Nullable String paramString)
  {
    Map localMap = (Map)null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lr.d
 * JD-Core Version:    0.7.0.1
 */