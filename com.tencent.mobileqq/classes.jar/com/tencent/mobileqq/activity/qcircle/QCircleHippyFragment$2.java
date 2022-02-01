package com.tencent.mobileqq.activity.qcircle;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
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
    if (RFLog.isColorLevel())
    {
      int i = RFLog.CLR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Hippy: initHippy error statusCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msg=");
      ((StringBuilder)localObject).append(paramString);
      RFLog.d("QCircleHippyFragment", i, ((StringBuilder)localObject).toString());
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    Object localObject = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    FeedCloudCommon.Entry localEntry1 = QCircleHippyFragment.a("time_cost", String.valueOf(d));
    FeedCloudCommon.Entry localEntry2 = QCircleHippyFragment.a("ret_code", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",module name:");
    localStringBuilder.append(QCircleHippyFragment.a(this.a));
    ((IQCircleReportApi)localObject).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleHippyFragment.a("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public void onSuccess()
  {
    QCircleHippyFragment.b(this.a).a().a();
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleHippyFragment", RFLog.CLR, "Hippy: initHippy success!");
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    FeedCloudCommon.Entry localEntry1 = QCircleHippyFragment.a("time_cost", String.valueOf(d));
    FeedCloudCommon.Entry localEntry2 = QCircleHippyFragment.a("ret_code", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("module name:");
    localStringBuilder.append(QCircleHippyFragment.a(this.a));
    localIQCircleReportApi.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleHippyFragment.a("attach_info", localStringBuilder.toString()) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */