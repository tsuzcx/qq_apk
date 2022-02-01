package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport$R5Builder;", "", "()V", "r5Json", "Lorg/json/JSONObject;", "getR5Json", "()Lorg/json/JSONObject;", "addCardReportJson", "cardReportJson", "", "addString", "key", "value", "build", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerReport$R5Builder
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  @NotNull
  public final R5Builder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cardReportJson");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Intrinsics.checkExpressionValueIsNotNull(str1, "key");
        String str2 = localJSONObject.optString(str1);
        Intrinsics.checkExpressionValueIsNotNull(str2, "json.optString(key)");
        a(str1, str2);
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RIJChannelBannerReport", 1, "[addCardReportJson] failed, e = " + localJSONException + ", cardReportJson = " + paramString);
    }
  }
  
  @NotNull
  public final R5Builder a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramString1))
      {
        this.a.put(paramString1, paramString2);
        return this;
      }
      QLog.i("RIJChannelBannerReport", 2, "[addString] failed, key is empty, value = " + paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      QLog.e("RIJChannelBannerReport", 1, "[addString] e = " + paramString1);
    }
    return this;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "r5Json.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerReport.R5Builder
 * JD-Core Version:    0.7.0.1
 */