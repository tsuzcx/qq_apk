package com.tencent.biz.pubaccount.readinjoy.dt;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtReportHelper;", "", "()V", "configPageParamsWithoutParams", "", "activity", "Landroid/app/Activity;", "pageID", "", "reportCardClickEvent", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJDtReportHelper
{
  public static final RIJDtReportHelper a = new RIJDtReportHelper();
  
  @JvmOverloads
  public final void a(@Nullable Activity paramActivity)
  {
    a(this, paramActivity, null, 2, null);
  }
  
  @JvmOverloads
  public final void a(@Nullable Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pageID");
    if (paramActivity == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, paramString);
    VideoReport.setPageParams(paramActivity, new RIJDtParamBuilder().a());
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject2 = null;
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder();
    Object localObject1;
    if (paramBaseArticleInfo != null)
    {
      localObject1 = paramBaseArticleInfo.innerUniqueID;
      localRIJDtParamBuilder = RIJDtParamBuilder.a(localRIJDtParamBuilder.e((String)localObject1).a("14"), null, 1, null).b("list");
      if (paramBaseArticleInfo == null) {
        break label124;
      }
      localObject1 = (Number)Long.valueOf(paramBaseArticleInfo.mChannelID);
      label59:
      localRIJDtParamBuilder = localRIJDtParamBuilder.a((Number)localObject1).c("click_contentid");
      localObject1 = localObject2;
      if (paramBaseArticleInfo != null) {
        localObject1 = paramBaseArticleInfo.dtReportBackendInfo;
      }
      localObject1 = localRIJDtParamBuilder.g((String)localObject1);
      if (paramBaseArticleInfo == null) {
        break label135;
      }
    }
    label135:
    for (paramBaseArticleInfo = (Number)Integer.valueOf(paramBaseArticleInfo.dtReportContentType);; paramBaseArticleInfo = (Number)Integer.valueOf(5))
    {
      VideoReport.reportEvent("clck", ((RIJDtParamBuilder)localObject1).b(paramBaseArticleInfo).a());
      return;
      localObject1 = null;
      break;
      label124:
      localObject1 = (Number)Integer.valueOf(0);
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper
 * JD-Core Version:    0.7.0.1
 */