package com.tencent.biz.pubaccount.readinjoy.model;

import ahcq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import oqs;
import rql;
import rqn;
import rtr;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = rqn.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      rql localrql = (rql)((Iterator)localObject).next();
      if (localrql.a != null)
      {
        localrql.b = 0;
        int i = rtr.b((QQAppInterface)this.this$0.a, localrql.a);
        ahcq.b((QQAppInterface)this.this$0.a, localrql.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localrql.a, 1008);
      }
    }
    localObject = bgmq.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    oqs.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */