package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class WeakNetHelper$1
  implements Runnable
{
  WeakNetHelper$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ReadInJoyUtils.a();
    QLog.d("WeakNetHelper", 1, new Object[] { "actionName = ", this.a, "\n", "r2 = ", str, " r5 = ", this.b });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", this.a, this.a, 0, 0, str, "", "", this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetHelper.1
 * JD-Core Version:    0.7.0.1
 */