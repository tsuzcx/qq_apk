package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSRijReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PTSLiteSwiperEventDispatcher$handleSwiperDrag$1
  implements Runnable
{
  PTSLiteSwiperEventDispatcher$handleSwiperDrag$1(String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperDrag] identifier is null.");
    }
    Object localObject = RIJTransMergeKanDianReport.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJTransMergeKanDianReport.baseR5Builder()");
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("type", "1");
    localObject = PTSRijReport.a(((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a(), this.jdField_a_of_type_JavaUtilHashMap);
    QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperDrag], actionName = 0X800A5CC, r5 = " + (String)localObject);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A5CC", "0X800A5CC", 0, 0, "", "", "", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperDrag.1
 * JD-Core Version:    0.7.0.1
 */