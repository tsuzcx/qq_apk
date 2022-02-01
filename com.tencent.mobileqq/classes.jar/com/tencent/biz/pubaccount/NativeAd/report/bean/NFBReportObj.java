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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/NFBReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "nfbActionID", "", "nfbActionTxt", "nfbRemark", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
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
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    if (AdReportUtil.a(paramAdReportData) != ReportAction.NFB) {
      return;
    }
    Object localObject1 = paramAdReportData.j();
    Object localObject2 = paramAdReportData.o();
    if (localObject2 != null)
    {
      this.a = "101";
      this.b = "我要吐槽";
      this.c = ((Bundle)localObject2).getString("ad_complain_txt", "");
      paramAdReportData = ((Bundle)localObject2).getString("ad_complain_tel", "");
      Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "tel");
      int i;
      if (((CharSequence)paramAdReportData).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append('_');
        ((StringBuilder)localObject2).append(paramAdReportData);
        this.c = Intrinsics.stringPlus((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramAdReportData.i());
        this.a = ((StringBuilder)localObject1).toString();
        return;
      }
      this.a = paramAdReportData.j();
      this.b = paramAdReportData.k();
    }
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "nfbActionID", this.a);
    ReportExKt.a(localJSONObject, "nfbActionTxt", this.b);
    ReportExKt.a(localJSONObject, "nfbRemark", this.c);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.NFBReportObj
 * JD-Core Version:    0.7.0.1
 */