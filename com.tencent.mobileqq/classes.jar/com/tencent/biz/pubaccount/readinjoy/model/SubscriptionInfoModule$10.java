package com.tencent.biz.pubaccount.readinjoy.model;

import ahpd;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pbr;
import sda;
import sdc;
import sgg;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = sdc.a().b((QQAppInterface)this.this$0.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      sda localsda = (sda)((Iterator)localObject).next();
      if (localsda.a != null)
      {
        localsda.b = 0;
        int i = sgg.b((QQAppInterface)this.this$0.a, localsda.a);
        ahpd.b((QQAppInterface)this.this$0.a, localsda.a, i);
        ((QQAppInterface)this.this$0.a).a().c(localsda.a, 1008);
      }
    }
    localObject = bhvy.a(this.this$0.a, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    pbr.a(this.this$0, false);
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