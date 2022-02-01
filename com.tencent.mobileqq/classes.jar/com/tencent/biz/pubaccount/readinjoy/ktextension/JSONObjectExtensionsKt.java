package com.tencent.biz.pubaccount.readinjoy.ktextension;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"putStringIfNotEmpty", "", "Lorg/json/JSONObject;", "key", "", "value", "defaultValue", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class JSONObjectExtensionsKt
{
  public static final void a(@NotNull JSONObject paramJSONObject, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$this$putStringIfNotEmpty");
    if (!TextUtils.isEmpty((CharSequence)paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
    while (paramString3 == null) {
      return;
    }
    paramJSONObject.put(paramString1, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ktextension.JSONObjectExtensionsKt
 * JD-Core Version:    0.7.0.1
 */