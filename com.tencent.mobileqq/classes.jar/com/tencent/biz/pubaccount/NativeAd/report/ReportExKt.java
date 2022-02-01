package com.tencent.biz.pubaccount.NativeAd.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"putData", "", "jsonObject", "Lorg/json/JSONObject;", "key", "", "value", "", "kandian_ad_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class ReportExKt
{
  public static final void a(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramObject != null) {
      paramJSONObject.put(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.ReportExKt
 * JD-Core Version:    0.7.0.1
 */