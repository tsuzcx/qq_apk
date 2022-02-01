package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJUgcUtils$6
  implements Runnable
{
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C1", "0X800B4C1", 0, 0, ReadInJoyUtils.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.6
 * JD-Core Version:    0.7.0.1
 */