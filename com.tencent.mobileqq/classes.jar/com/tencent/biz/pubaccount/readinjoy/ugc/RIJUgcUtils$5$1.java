package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUgcUtils$5$1
  implements Runnable
{
  RIJUgcUtils$5$1(RIJUgcUtils.5 param5) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C2", "0X800B4C2", 0, 0, ReadInJoyUtils.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.5.1
 * JD-Core Version:    0.7.0.1
 */