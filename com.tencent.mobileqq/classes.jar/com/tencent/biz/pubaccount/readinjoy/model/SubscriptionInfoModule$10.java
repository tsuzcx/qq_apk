package com.tencent.biz.pubaccount.readinjoy.model;

import alpb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bnrf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pqx;
import twi;
import twk;
import tzq;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = twk.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      twi localtwi = (twi)((Iterator)localObject).next();
      if (localtwi.a != null)
      {
        localtwi.b = 0;
        int i = tzq.b((QQAppInterface)this.this$0.a, localtwi.a);
        alpb.b((QQAppInterface)this.this$0.a, localtwi.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localtwi.a, 1008);
      }
    }
    localObject = bnrf.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    pqx.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */