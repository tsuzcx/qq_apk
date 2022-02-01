package com.tencent.mobileqq.activity.qcircle;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class QCircleHippyFragment$2
  implements HippyQQEngine.HippyQQEngineListener
{
  QCircleHippyFragment$2(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    QCircleHippyFragment.b(this.a);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Hippy: initHippy error statusCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QCircleHippyFragment", 2, ((StringBuilder)localObject).toString());
    }
    double d = 0.0D;
    if (QCircleHippyFragment.d(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.d(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    Object localObject = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    FeedCloudCommon.Entry localEntry1 = QCircleHippyFragment.a("time_cost", String.valueOf(d));
    FeedCloudCommon.Entry localEntry2 = QCircleHippyFragment.a("ret_code", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",module name:");
    localStringBuilder.append(QCircleHippyFragment.c(this.a));
    ((IQCircleReportApi)localObject).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleHippyFragment.a("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public void onSuccess()
  {
    QCircleHippyFragment.e(this.a).i().a();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHippyFragment", 2, "Hippy: initHippy success!");
    }
    double d = 0.0D;
    if (QCircleHippyFragment.d(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.d(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    IQCircleReportApi localIQCircleReportApi = (IQCircleReportApi)QRoute.api(IQCircleReportApi.class);
    FeedCloudCommon.Entry localEntry1 = QCircleHippyFragment.a("time_cost", String.valueOf(d));
    FeedCloudCommon.Entry localEntry2 = QCircleHippyFragment.a("ret_code", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("module name:");
    localStringBuilder.append(QCircleHippyFragment.c(this.a));
    localIQCircleReportApi.reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleHippyFragment.a("attach_info", localStringBuilder.toString()) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */