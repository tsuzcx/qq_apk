package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper.IMoveUgcVideoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "invoke", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment$onCreate$1$1"}, k=3, mv={1, 1, 16})
final class SelectTopicFragment$onCreate$$inlined$let$lambda$1
  extends Lambda
  implements Function1<ColumnInfo, Unit>
{
  SelectTopicFragment$onCreate$$inlined$let$lambda$1(SlidingUpDialog paramSlidingUpDialog, FragmentActivity paramFragmentActivity, SelectTopicFragment paramSelectTopicFragment, int paramInt, String paramString)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ColumnInfo paramColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    QLog.i("SelectTopicFragment", 1, "select topic, topic=" + paramColumnInfo);
    this.$dialog.dismiss();
    Object localObject = RIJQQAppInterfaceUtil.a();
    int i;
    if (localObject != null)
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
      if (RIJUgcUtils.m())
      {
        i = 1;
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("ugc_video_flag", Integer.valueOf(i));
        if (!RIJUgcUtils.h()) {
          break label174;
        }
        i = 1;
        label90:
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("ugc_column_flag", Integer.valueOf(i)).a("from_page", Integer.valueOf(this.$from$inlined)).a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800ADD0", (String)localObject);
      }
    }
    for (;;)
    {
      PublishVideoHelper.a((List)CollectionsKt.arrayListOf(new String[] { this.$rowKey$inlined }), paramColumnInfo.columnID, (PublishVideoHelper.IMoveUgcVideoCallback)new SelectTopicFragment.onCreate..inlined.let.lambda.1.1(this, paramColumnInfo));
      return;
      i = 0;
      break;
      label174:
      i = 0;
      break label90;
      QLog.e("SelectTopicFragment", 1, "getQQApp, app == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment.onCreate..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */