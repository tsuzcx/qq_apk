package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stReportItem;
import umq;

public final class UserActionReportPresenter$1
  implements Runnable
{
  public void run()
  {
    stReportItem localstReportItem = umq.a();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 121;
    umq.a(localstReportItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter.1
 * JD-Core Version:    0.7.0.1
 */