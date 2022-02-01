package com.tencent.biz.pubaccount.readinjoy.view.widget;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUserLevelDialog$2
  implements Runnable
{
  RIJUserLevelDialog$2(RIJUserLevelDialog paramRIJUserLevelDialog, String paramString) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", this.a, this.a, 0, 0, ReadInJoyUtils.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.2
 * JD-Core Version:    0.7.0.1
 */