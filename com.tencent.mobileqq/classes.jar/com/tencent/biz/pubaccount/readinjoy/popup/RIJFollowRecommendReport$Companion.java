package com.tencent.biz.pubaccount.readinjoy.popup;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowRecommendReport$Companion;", "", "()V", "ACTION_NAME_RECOMMEND_CARD_EXPOSE", "", "ACTION_NAME_RECOMMEND_DIALOG_CLOSE", "AVATOR_CLICK", "CARD_CLICK", "FOLLOW_BUTTON_CLICK", "KEY_ACC_REC_LOCATION", "KEY_APP_TYPE", "KEY_BUTTON_TYPE", "KEY_CLICK_TYPE", "KEY_CLOSE_WAY", "KEY_PUIN", "KEY_SCENE_TYPE", "KEY_TRIGGER_TYPE", "KEY_UGC_UIN", "KEY_UIN", "TAG", "getBaseR5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "source", "", "(Ljava/lang/Integer;)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "reportData", "", "actionName", "r5", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowRecommendReport$Companion
{
  @NotNull
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@Nullable Integer paramInteger)
  {
    int i = 2;
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    int j;
    if (paramInteger == null) {
      j = 2;
    }
    for (;;)
    {
      localReportR5Builder.b("uin", ReadInJoyUtils.a());
      localReportR5Builder.b("acc_rec_location", j);
      localReportR5Builder.b("trigger_type", 1);
      localReportR5Builder.b("scene_type", i);
      localReportR5Builder.b("app_type", 1);
      Intrinsics.checkExpressionValueIsNotNull(localReportR5Builder, "r5Builder");
      return localReportR5Builder;
      if (paramInteger.intValue() != 2) {
        break;
      }
      j = 4;
      i = 3;
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    QLog.i("RIJFollowRecommendReportUtil", 1, "[reportData] actionName = " + paramString1 + ", r5 = " + paramString2);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendReport.Companion
 * JD-Core Version:    0.7.0.1
 */