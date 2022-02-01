package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;

class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = TroopBarAssistantManager.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscriptionFeed localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
      if (localSubscriptionFeed.a != null)
      {
        localSubscriptionFeed.b = 0;
        int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)this.this$0.a, localSubscriptionFeed.a);
        RecentUtil.b((QQAppInterface)this.this$0.a, localSubscriptionFeed.a, i);
        ((QQAppInterface)this.this$0.a).getMessageFacade().c(localSubscriptionFeed.a, 1008);
      }
    }
    localObject = ReadInJoyHelper.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    SubscriptionInfoModule.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */