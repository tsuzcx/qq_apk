package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;

final class RecentUtil$5
  implements Runnable
{
  RecentUtil$5(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a != null)
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanAllThirdQQUnreadMsgNum(this.a);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanAllSubAccountMessageUnread(this.a, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.5
 * JD-Core Version:    0.7.0.1
 */