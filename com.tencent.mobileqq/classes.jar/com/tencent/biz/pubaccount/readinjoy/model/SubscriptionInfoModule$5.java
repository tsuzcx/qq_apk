package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptionInfoModule$5
  implements Runnable
{
  SubscriptionInfoModule$5(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString, Context paramContext) {}
  
  public void run()
  {
    TroopBarAssistantManager.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.this$0.a, this.jdField_a_of_type_AndroidContentContext, SubscriptionInfoModule.a(this.this$0));
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString);
    RecentUtil.b((QQAppInterface)this.this$0.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.this$0.a).getMessageFacade().c(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */