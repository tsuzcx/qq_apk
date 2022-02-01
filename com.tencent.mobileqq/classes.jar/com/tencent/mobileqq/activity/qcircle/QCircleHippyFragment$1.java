package com.tencent.mobileqq.activity.qcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleHippyFragment$1
  implements View.OnClickListener
{
  QCircleHippyFragment$1(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onClick(View paramView)
  {
    QCircleHippyFragment.a(this.a).a().a();
    QCircleHippyFragment.a(this.a);
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    FeedCloudCommon.Entry localEntry = QCircleHippyFragment.a("ret_code", "-1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("network error,module name:");
    localStringBuilder.append(QCircleHippyFragment.a(this.a));
    localIQCircleReportApi.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { localEntry, QCircleHippyFragment.a("attach_info", localStringBuilder.toString()) }), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */