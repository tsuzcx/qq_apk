package com.tencent.biz.pubaccount.NativeAd.report.bean;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/NFBReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "nfbActionID", "", "nfbActionTxt", "nfbRemark", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NFBReportObj
  extends IReportObj
{
  private String a;
  private String b;
  private String c;
  
  @NotNull
  public String a()
  {
    return "nfb";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "nfbActionID", this.a);
    ReportExKt.a(localJSONObject, "nfbActionTxt", this.b);
    ReportExKt.a(localJSONObject, "nfbRemark", this.c);
    return localJSONObject;
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    if (AdReportUtil.a(paramAdReportData) != ReportAction.NFB) {}
    String str;
    for (;;)
    {
      return;
      str = paramAdReportData.a();
      Bundle localBundle = paramAdReportData.a();
      if (localBundle == null) {
        break;
      }
      this.a = "101";
      this.b = "我要吐槽";
      this.c = localBundle.getString("ad_complain_txt", "");
      paramAdReportData = localBundle.getString("ad_complain_tel", "");
      Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "tel");
      if (((CharSequence)paramAdReportData).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.c = Intrinsics.stringPlus(this.c, '_' + paramAdReportData);
        return;
      }
    }
    if (TextUtils.isEmpty((CharSequence)str))
    {
      this.a = ("" + paramAdReportData.a());
      return;
    }
    this.a = paramAdReportData.a();
    this.b = paramAdReportData.b();
  }
  
  public boolean a()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.NFBReportObj
 * JD-Core Version:    0.7.0.1
 */