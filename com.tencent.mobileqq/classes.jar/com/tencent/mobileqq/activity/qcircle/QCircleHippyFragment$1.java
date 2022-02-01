package com.tencent.mobileqq.activity.qcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
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
    this.a.mViolaUiDelegate.d();
    QCircleHippyFragment.a(this.a);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleHippyFragment.a("ret_code", "-1"), QCircleHippyFragment.a("attach_info", "network error,module name:" + QCircleHippyFragment.a(this.a)) }), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */