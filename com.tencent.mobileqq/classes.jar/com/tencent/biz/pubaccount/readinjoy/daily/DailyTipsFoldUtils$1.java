package com.tencent.biz.pubaccount.readinjoy.daily;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class DailyTipsFoldUtils$1
  implements Runnable
{
  DailyTipsFoldUtils$1(ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    QLog.i("DailyTipsFoldUtils", 2, "[foldDailyTips], smoothScroll.");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    View localView = this.a.getChildAt(this.a.getHeaderViewsCount());
    localValueAnimator.addUpdateListener(new DailyTipsFoldUtils.1.1(this, localView, localView.getHeight()));
    localValueAnimator.addListener(new DailyTipsFoldUtils.1.2(this, localView));
    localValueAnimator.start();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A577", "0X800A577", 0, 0, ReadInJoyUtils.a(), "", "", RIJTransMergeKanDianReport.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils.1
 * JD-Core Version:    0.7.0.1
 */