package com.tencent.biz.pubaccount.readinjoy.view.widget;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUserLevelDialog$1
  implements Runnable
{
  RIJUserLevelDialog$1(RIJUserLevelDialog paramRIJUserLevelDialog) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C1", "0X800B4C1", 0, 0, ReadInJoyUtils.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.1
 * JD-Core Version:    0.7.0.1
 */