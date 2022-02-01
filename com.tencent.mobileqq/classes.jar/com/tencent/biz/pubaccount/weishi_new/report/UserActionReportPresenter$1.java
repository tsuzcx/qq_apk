package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stReportItem;
import uvi;

public final class UserActionReportPresenter$1
  implements Runnable
{
  public void run()
  {
    stReportItem localstReportItem = uvi.a();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 121;
    uvi.a(localstReportItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter.1
 * JD-Core Version:    0.7.0.1
 */