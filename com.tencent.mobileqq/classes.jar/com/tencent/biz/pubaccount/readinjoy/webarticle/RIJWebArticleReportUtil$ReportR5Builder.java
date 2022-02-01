package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.QbSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "", "()V", "r5", "Lorg/json/JSONObject;", "getR5", "()Lorg/json/JSONObject;", "addString", "key", "", "value", "build", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleReportUtil$ReportR5Builder
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  public RIJWebArticleReportUtil$ReportR5Builder()
  {
    JSONObject localJSONObject = this.a;
    if (RIJWebArticleUtil.a.b())
    {
      localObject = "1";
      localJSONObject.put("param_webviewPoolReuse", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.c()) {
        break label233;
      }
      localObject = "1";
      label57:
      localJSONObject.put("param_useVasSonic", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.e()) {
        break label239;
      }
      localObject = "1";
      label82:
      localJSONObject.put("param_usePreload", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.f()) {
        break label245;
      }
      localObject = "1";
      label107:
      localJSONObject.put("param_warmup_template", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.g()) {
        break label251;
      }
      localObject = "1";
      label132:
      localJSONObject.put("param_use_web_data_preload", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.h()) {
        break label257;
      }
      localObject = "1";
      label157:
      localJSONObject.put("param_foreground_preload", localObject);
      localJSONObject = this.a;
      localObject = BaseApplicationImpl.sApplication;
      if (localObject == null) {
        break label263;
      }
      localObject = ((BaseApplicationImpl)localObject).getApplicationContext();
      label183:
      if (QbSdk.getTbsVersion((Context)localObject) == 0) {
        break label268;
      }
      localObject = "1";
      label193:
      localJSONObject.put("param_isX5", localObject);
      localJSONObject = this.a;
      if (!RIJWebArticleUtil.a.i()) {
        break label274;
      }
    }
    label257:
    label263:
    label268:
    label274:
    for (Object localObject = "1";; localObject = "0")
    {
      localJSONObject.put("param_load_url_optimize", localObject);
      return;
      localObject = "0";
      break;
      label233:
      localObject = "0";
      break label57;
      label239:
      localObject = "0";
      break label82;
      label245:
      localObject = "0";
      break label107;
      label251:
      localObject = "0";
      break label132;
      localObject = "0";
      break label157;
      localObject = null;
      break label183;
      localObject = "0";
      break label193;
    }
  }
  
  @NotNull
  public final ReportR5Builder a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "r5.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleReportUtil.ReportR5Builder
 * JD-Core Version:    0.7.0.1
 */