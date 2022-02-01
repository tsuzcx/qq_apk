package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

class SubscriptFeedsActivity$8
  implements AsyncBack
{
  SubscriptFeedsActivity$8(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("HtmlOffline.checkUpByBusinessId businessId=2278, code=");
      paramString.append(paramInt);
      QLog.d("SubscriptFeedsActivity", 2, paramString.toString());
    }
    this.a.app.getApplication();
    int i = NetworkUtil.getSystemNetwork(MobileQQ.getContext());
    paramString = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    paramString.put("network", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    paramString.put("status_code", localStringBuilder.toString());
    StatisticCollector.getInstance(this.a).collectPerformance(null, "subscription_htmloffline", true, 0L, 0L, paramString, "", false);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.8
 * JD-Core Version:    0.7.0.1
 */