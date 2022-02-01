package com.tencent.mobileqq.activity.qcircle;

import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleHippyFragment$2
  implements HippyQQEngine.HippyQQEngineListener
{
  QCircleHippyFragment$2(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    QCircleHippyFragment.a(this.a);
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleHippyFragment", RFLog.CLR, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleHippyFragment.a("time_cost", String.valueOf(d)), QCircleHippyFragment.a("ret_code", String.valueOf(paramInt)), QCircleHippyFragment.a("attach_info", "errMsg:" + paramString + ",module name:" + QCircleHippyFragment.a(this.a)) }), false);
  }
  
  public void onSuccess()
  {
    this.a.mViolaUiDelegate.d();
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleHippyFragment", RFLog.CLR, "Hippy: initHippy success!");
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleHippyFragment.a("time_cost", String.valueOf(d)), QCircleHippyFragment.a("ret_code", "0"), QCircleHippyFragment.a("attach_info", "module name:" + QCircleHippyFragment.a(this.a)) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */