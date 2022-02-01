package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUgcUtils$4$1
  implements Runnable
{
  RIJUgcUtils$4$1(RIJUgcUtils.4 param4) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C4", "0X800B4C4", 0, 0, ReadInJoyUtils.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.4.1
 * JD-Core Version:    0.7.0.1
 */