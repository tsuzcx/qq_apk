package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil;", "", "()V", "KEY_PARAM_FOREGROUND_PRELOAD", "", "KEY_PARAM_HIT_PRELOAD", "KEY_PARAM_HIT_WEB_DATA_PRELOAD", "KEY_PARAM_IS_X5", "KEY_PARAM_LOAD_URL_OPTIMIZE", "KEY_PARAM_USE_PRELOAD", "KEY_PARAM_USE_WEB_DATA_PRELOAD", "KEY_PARAM_VAS_SONIC", "KEY_PARAM_WARMUP_TEMPLATE", "KEY_PARAM_WEBVIEW_POOL_REUSE", "REPORT_ACTION_WEB_ARTICLE_COST", "TAG", "reportWebArticle", "", "actionName", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "reportWebArticleDetailCost", "reportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sonicClientImpl", "Lcom/tencent/mobileqq/webview/sonic/SonicClientImpl;", "ReportR5Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleReportUtil
{
  public static final RIJWebArticleReportUtil a = new RIJWebArticleReportUtil();
  
  public final void a(@NotNull String paramString, @NotNull RIJWebArticleReportUtil.ReportR5Builder paramReportR5Builder)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionName");
    Intrinsics.checkParameterIsNotNull(paramReportR5Builder, "r5Builder");
    QLog.i("RIJWebArticleReportUtil", 1, "[reportWebArticle] actionName = " + paramString + ", r5 = " + paramReportR5Builder.a());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", paramReportR5Builder.a(), false);
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap, @Nullable SonicClientImpl paramSonicClientImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "reportMap");
    RIJWebArticleReportUtil.ReportR5Builder localReportR5Builder = new RIJWebArticleReportUtil.ReportR5Builder();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localReportR5Builder.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (paramSonicClientImpl != null)
    {
      paramHashMap = paramSonicClientImpl.getSession();
      if ((paramHashMap == null) || (paramHashMap.isPreload() != true)) {}
    }
    for (paramHashMap = "1";; paramHashMap = "0")
    {
      localReportR5Builder.a("param_hitPreload", paramHashMap);
      a("0X800B4EF", localReportR5Builder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleReportUtil
 * JD-Core Version:    0.7.0.1
 */