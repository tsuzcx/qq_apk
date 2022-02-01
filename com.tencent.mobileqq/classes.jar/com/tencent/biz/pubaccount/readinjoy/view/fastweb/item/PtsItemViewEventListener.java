package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/PtsItemViewEventListener;", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "()V", "addR5CommonParams", "", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "onExposureTriggered", "id", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "reportWithCommonParams", "reportName", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PtsItemViewEventListener
  extends DefaultPTSLiteEventListener
{
  public static final PtsItemViewEventListener.Companion a = new PtsItemViewEventListener.Companion(null);
  
  private final void a(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, BaseArticleInfo paramBaseArticleInfo)
  {
    long l;
    if (paramBaseArticleInfo != null)
    {
      l = paramBaseArticleInfo.mAlgorithmID;
      paramReportR5Builder = paramReportR5Builder.a(l).e().f().l();
      if (paramBaseArticleInfo == null) {
        break label49;
      }
    }
    label49:
    for (int i = (int)paramBaseArticleInfo.mChannelID;; i = 0)
    {
      paramReportR5Builder.a(i);
      return;
      l = 0L;
      break;
    }
  }
  
  private final void a(String paramString, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    Object localObject1 = BaseActivity.sTopActivity;
    Object localObject2;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    AppInterface localAppInterface;
    String str;
    label67:
    label76:
    Object localObject3;
    if ((localObject1 instanceof FastWebActivity))
    {
      localObject2 = ((FastWebActivity)localObject1).a;
      a(paramReportR5Builder, (BaseArticleInfo)localObject2);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
      str = ReadInJoyUtils.a();
      if (localObject2 == null) {
        break label163;
      }
      localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);
      localObject1 = String.valueOf(localObject1);
      if (localObject1 == null) {
        break label168;
      }
      if (localObject2 == null) {
        break label174;
      }
      localObject3 = Integer.valueOf(((ArticleInfo)localObject2).mStrategyId);
      label91:
      localObject3 = String.valueOf(localObject3);
      if (localObject3 == null) {
        break label180;
      }
      label103:
      if (localObject2 == null) {
        break label187;
      }
      localObject2 = ((ArticleInfo)localObject2).innerUniqueID;
      label115:
      localObject2 = String.valueOf(localObject2);
      if (localObject2 == null) {
        break label193;
      }
    }
    for (;;)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localAppInterface, "P_CliOper", "Pb_account_lifeservice", str, paramString, paramString, 0, 0, (String)localObject1, (String)localObject3, (String)localObject2, paramReportR5Builder.a(), false);
      return;
      localObject2 = null;
      break;
      label163:
      localObject1 = null;
      break label67;
      label168:
      localObject1 = "";
      break label76;
      label174:
      localObject3 = null;
      break label91;
      label180:
      localObject3 = "";
      break label103;
      label187:
      localObject2 = null;
      break label115;
      label193:
      localObject2 = "";
    }
  }
  
  public void onExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap == null) {
      QLog.d("PtsItemViewEventListener", 1, "[onExposureTriggered] dataSet is null");
    }
    do
    {
      return;
      paramView = (String)paramHashMap.get("exposureReportName");
    } while (paramView == null);
    try
    {
      paramString = new RIJTransMergeKanDianReport.ReportR5Builder(new JSONObject((Map)paramHashMap));
      a(paramView, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
      }
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    if (paramHashMap != null)
    {
      paramPTSComposer = (String)paramHashMap.get("jumpUrl");
      if (paramPTSComposer != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramPTSComposer, "dataSet?.get(PTSConstant…A_SET_JUMP_URL) ?: return");
        if (paramView == null) {
          break label92;
        }
        paramString = paramView.getContext();
      }
    }
    for (;;)
    {
      ReadInJoyUtils.a(paramString, paramPTSComposer);
      paramView = (String)paramHashMap.get("clickReportName");
      if (paramView != null) {}
      try
      {
        paramString = new RIJTransMergeKanDianReport.ReportR5Builder(new JSONObject((Map)paramHashMap));
        a(paramView, paramString);
        return;
        label92:
        paramString = null;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.PtsItemViewEventListener
 * JD-Core Version:    0.7.0.1
 */