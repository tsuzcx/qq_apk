package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptionInfoModule$6
  implements Runnable
{
  SubscriptionInfoModule$6(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString) {}
  
  public void run()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)this.this$0.a, this.a);
    RecentUtil.b((QQAppInterface)this.this$0.a, this.a, i);
    ((QQAppInterface)this.this$0.a).getMessageFacade().c(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */