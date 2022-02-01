package com.tencent.luggage.wxa.lr;

import com.tencent.luggage.wxa.ba.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "Lcom/tencent/luggage/base/ICustomize;", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface a
  extends b
{
  @NotNull
  public abstract c a();
  
  @Nullable
  public abstract c a(@NotNull com.tencent.luggage.wxa.jx.c paramc);
  
  @Nullable
  public abstract c a(@NotNull String paramString);
  
  @Nullable
  public abstract c a(@NotNull JSONObject paramJSONObject, @NotNull com.tencent.luggage.wxa.jx.c paramc);
  
  @Nullable
  public abstract String a(@NotNull JSONObject paramJSONObject);
  
  @Nullable
  public abstract String b(@NotNull com.tencent.luggage.wxa.jx.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lr.a
 * JD-Core Version:    0.7.0.1
 */